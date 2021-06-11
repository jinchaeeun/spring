package hustar.booking.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.com.cmm.service.CommonService;
import hustar.booking.service.BookingVO;
import hustar.member.service.MemberVO;

@Controller
public class BookingController {	
	
	@Resource(name="commonService") 
	CommonService commonService;

	@RequestMapping("/booking/list.do")
	public String list() throws Exception {
		return "/booking/list";
	}
	
	@RequestMapping("/booking/mypage.do")
	public String mypage() throws Exception {
		return "/booking/mypage";
	}
	
	@RequestMapping("/booking/view.do")
	public String view(String location, Model model) throws Exception {
		
		model.addAttribute("location", location);
		
		return "/booking/view";
	}	
	
	@RequestMapping("/booking/booking.do")
	public String list_write(BookingVO bookingVO, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		
		MemberVO loginVO = (MemberVO) session.getAttribute("login");
		
		if(loginVO == null) {
			redirectAttributes.addFlashAttribute("msg", "로그인이필요합니다.");
			return "redirect:/member/login.do";
		}
		//bookingVO에 담기
		bookingVO.setId(loginVO.getId()); 
		bookingVO.setName(loginVO.getName());
		
		commonService.insert(bookingVO, null, null, "bookingDAO.insertBooking");
		
		return "redirect:/booking/list.do";
	}
	
}
