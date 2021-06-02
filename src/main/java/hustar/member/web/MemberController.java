package hustar.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {	
	
	@GetMapping("join.do")
	public String join() {
		return "/member/join";
	}
	
	@GetMapping("login.do")
	public String login() {
		return "/member/login";
	}
}
