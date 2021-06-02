package hustar.page.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {	
	
	@RequestMapping("/page/intro.do")
	public String intro() {
		return "/page/intro";
	}
}
