package hustar.member.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.service.CommonService;
import hustar.member.service.MemberVO;

@Controller
public class MemberController extends ComDefaultVO{	
	
	@Resource(name="commonService") 
	CommonService commonService; //어노테이션으로 주면 new 안해도 객체 생성까지 된다.
	
	@Resource(name="jsonView")
	MappingJackson2JsonView jsonView;
	
	
	@RequestMapping("/member/join.do")
	public String join(HttpServletRequest request,
			Model model) throws Exception {
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if(inputFlashMap != null) {
			model.addAttribute("msg", inputFlashMap.get("msg"));
			System.out.println("msg = " + inputFlashMap.get("msg"));
		}
		return "/member/join";
	}
	
	@RequestMapping("/member/login.do")
	public String login(HttpServletRequest request,
			Model model) throws Exception {
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if(inputFlashMap != null) {
			model.addAttribute("msg", inputFlashMap.get("msg"));
			System.out.println("msg = " + inputFlashMap.get("msg"));
		}
		return "/member/login";
	}
	
	@RequestMapping("/member/joinInsert.do")
	public String JoinInsert(
			@ModelAttribute("memberVO") MemberVO memberVO, 
			RedirectAttributes redirectAttributes) throws Exception {
			
		System.out.println("id = "+ memberVO.getId());
		System.out.println("name = "+ memberVO.getName());
		System.out.println("password = "+ memberVO.getPassword());
		System.out.println("phone = "+ memberVO.getPhone());
		
		int cnt = commonService.selectListTotCnt(memberVO, null, null, "memberDAO.selectMemberCnt");
		System.out.println("cnt = " + cnt);
		
		if(cnt>0) {
			redirectAttributes.addFlashAttribute("msg", "이미 가입된 아이디입니다.");
		}else {
			//패스워드 암호화
			String encpass = BCrypt.hashpw(memberVO.getPassword(), BCrypt.gensalt()); //(데이터를 가지고 와서, gensalt 암호화)
			memberVO.setPassword(encpass);											  //데이터베이스에 넣을 수 있게 암호화한 값 다시 전달
			//데이터 삽입
			commonService.insert(memberVO, null, null, "memberDAO.insertMember");
			redirectAttributes.addFlashAttribute("msg", "회원가입 성공");
		}
		return "redirect:/member/join.do"; //forward도 가능. redirect는 클라이언트가 다시 요청, forward는 요청 다음에 서버 내에서 처리 후에 넘어간 다음에 
	}
	
	@RequestMapping("/member/checkId.do")
	public ModelAndView checkId(ModelMap model, @ModelAttribute("memberVO") MemberVO memberVO, 
			RedirectAttributes redirectAttributes) throws Exception{
		
		int cnt = commonService.selectListTotCnt(memberVO, null, null, "memberDAO.selectMemberCnt");
		System.out.println("cnt = " + cnt);
		
		if(cnt>0) {
			model.addAttribute("duplicate", true);
		}else {
			model.addAttribute("duplicate", false);
		}
		
		
		return new ModelAndView(jsonView);
	}
	
	@RequestMapping("/member/actionLogin.do")
	public String actionLogin(
			@ModelAttribute("memberVO") MemberVO memberVO, 
			RedirectAttributes redirectAttributes) throws Exception{
		MemberVO loginVO = (MemberVO) commonService.selectView(memberVO, null, null, "memberDAO.selectMemberView");
		
		if(loginVO != null) {
			if (BCrypt.checkpw(memberVO.getPassword(), loginVO.getPassword()) == true){
				//로그인세션
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				request.getSession().setAttribute("login", loginVO);
				return "redirect:/index.do";
			}else {
				// 비밀번호 불일치
				redirectAttributes.addFlashAttribute("msg", "비밀번호가 맞지 않습니다.");
			} 
		}else {
			// ID 존재하지 않음
			redirectAttributes.addFlashAttribute("msg", "존재하지않는 ID입니다.");
		} 
		
		return "redirect:/member/login.do";
	}

	
	@RequestMapping("/member/actionLogout.do")
	public String actionLogout() throws Exception{
		RequestAttributes requestAttribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		requestAttribute.setAttribute("login", null, RequestAttributes.SCOPE_SESSION);
		
		return "redirect:/member/login.do";
	}
	
	@RequestMapping("/member/actionLoginAsync.do")
	public ModelAndView actionLoginAsync(ModelMap model, String id, String password) throws Exception{ //memberVO안쓰고 직접 id,pw받아옴
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO.setPassword(password);
		
		MemberVO loginVO = (MemberVO) commonService.selectView(memberVO, null, null, "memberDAO.selectMemberView");
		
		if(loginVO != null) {
			if(BCrypt.checkpw(memberVO.getPassword(), loginVO.getPassword())==true) {
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				request.getSession().setAttribute("login", loginVO);
				
				System.out.println("auth = " + loginVO.getAuth());
				model.addAttribute("login", true);
			} else {
				model.addAttribute("login", false);
			}
		} else {
			model.addAttribute("login", false);
		}
		
		return new ModelAndView(jsonView);
	}
}
