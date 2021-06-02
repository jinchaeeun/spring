package hustar.bbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bbs/**")
public class BbsController {	
	
	@GetMapping("free_list.do")
	public String free_list() {
		return "/bbs/free_list";
	}
	
	@GetMapping("free_write.do")
	public String free_write() {
		return "/bbs/free_write";
	}
	
	@GetMapping("gallery_list.do")
	public String gallery_list() {
		return "/bbs/gallery_list";
	}
	
	@GetMapping("gallery_view.do")
	public String gallery_view() {
		return "/bbs/gallery_view";
	}
	@GetMapping("gallery_write.do")
	public String gallery_write() {
		return "/bbs/gallery_write";
	}
	
	@GetMapping("notice_list.do")
	public String notice_list() {
		return "/bbs/notice_list";
	}
	
	@GetMapping("notice_view.do")
	public String notice_view() {
		return "/bbs/notice_view";
	}
	
	@GetMapping("notice_write.do")
	public String notice_write() {
		return "/bbs/notice_write";
	}
}
