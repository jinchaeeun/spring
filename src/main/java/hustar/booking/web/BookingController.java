package hustar.booking.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import egovframework.com.cmm.service.CommonService;
import hustar.booking.service.BookingVO;
import hustar.member.service.MemberVO;

@Controller
public class BookingController {	
	
	@Resource(name="commonService") 
	CommonService commonService;

   @Resource(name ="jsonView")
   MappingJackson2JsonView jsonView;
   
	@RequestMapping("/booking/list.do")
	public String list() throws Exception {
		return "/booking/list";
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
	
   @RequestMapping("/booking/mypage.do")
   public String mypage(
         BookingVO searchVO,
         Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
      
	  MemberVO loginVO = (MemberVO) session.getAttribute("login");
	  
	  if(loginVO == null) {
			redirectAttributes.addFlashAttribute("msg", "로그인이필요합니다.");
			return "redirect:/member/login.do";
		}
	  
	  searchVO.setId(loginVO.getId());
	  searchVO.setAuth(loginVO.getAuth());
	  
      List<BookingVO> bookingVOList = (List<BookingVO>) commonService.selectList(searchVO, null, null,"bookingDAO.selectBookingList");
      
      model.addAttribute("bookingVOList", bookingVOList);
      return "/booking/mypage";
   }
	
   @RequestMapping("/booking/modify_status.do")
   public ModelAndView modify_status(BookingVO bookingVO, Model model) throws Exception{
	   
	   commonService.update(bookingVO, null, null, "bookingDAO.updateBooking");
	   
	   model.addAttribute("success", "true");
	   
	   return new ModelAndView(jsonView);
   }
}
