package hustar.booking.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking/**")
public class BookingController {	
	
	@GetMapping("list_write.do")
	public String list_write() {
		return "/booking/list_write";
	}
	
	@GetMapping("list.do")
	public String list() {
		return "/booking/list";
	}
	
	@GetMapping("mypage.do")
	public String mypage() {
		return "/booking/mypage";
	}
	
	@GetMapping("view.do")
	public String view() {
		return "/booking/view";
	}	
}
