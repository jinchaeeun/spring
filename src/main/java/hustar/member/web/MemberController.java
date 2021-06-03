package hustar.member.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.service.CommonService;
import hustar.member.service.MemberVO;

@Controller
public class MemberController extends ComDefaultVO{	
	
	@Resource(name="commonService") 
	CommonService commonService; //어노테이션으로 주면 new 안해도 객체 생성까지 된다.
	
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
	public String login() throws Exception {
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
			commonService.insert(memberVO, null, null, "memberDAO.insertMember");
			redirectAttributes.addFlashAttribute("msg", "회원가입 성공");
		}
		return "redirect:/member/join.do"; //forward도 가능. redirect는 클라이언트가 다시 요청, forward는 요청 다음에 서버 내에서 처리 후에 넘어간 다음에 
	}
}
