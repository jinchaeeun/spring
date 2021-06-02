package hustar.member.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.service.CommonService;
import hustar.member.service.MemberVO;

@Controller
public class MemberController extends ComDefaultVO{	
	
	@Resource(name="commonService") 
	CommonService commonService; //어노테이션으로 주면 new 안해도 객체 생성까지 된다.
	
	@RequestMapping("/member/join.do")
	public String join() throws Exception {
		return "/member/join";
	}
	
	@RequestMapping("/member/login.do")
	public String login() throws Exception {
		return "/member/login";
	}
	
	@RequestMapping("/member/joinInsert.do")
	public String JoinInsert(
			@ModelAttribute("memberVO") MemberVO memberVO) throws Exception {
			
		System.out.println("id = "+ memberVO.getId());
		System.out.println("name = "+ memberVO.getName());
		System.out.println("password = "+ memberVO.getPassword());
		System.out.println("phone = "+ memberVO.getPhone());
		
		
		commonService.insert(memberVO, null, null, "memberDAO.insertMember");
		return "redirect:/member/join.do"; //forward도 가능. redirect는 클라이언트가 다시 요청, forward는 요청 다음에 서버 내에서 처리 후에 넘어간 다음에 
	}
}
