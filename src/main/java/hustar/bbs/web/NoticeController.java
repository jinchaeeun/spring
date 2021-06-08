package hustar.bbs.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import egovframework.com.cmm.service.CommonService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import hustar.bbs.service.NoticeVO;
import hustar.member.service.MemberVO;

@Controller
public class NoticeController {	
	
	@Resource(name="commonService") 
	CommonService commonService;

	
	@RequestMapping("/bbs/notice_list.do")
	public String notice_list(Model model, NoticeVO searchVO) throws Exception {
		
		//검색 값 가져오는 지 확인
		System.out.println("searchKeyword = " + searchVO.getSearchKeyword());
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getRecordCountPerPage()); 	//한 페이지 당 몇개 표시
		paginationInfo.setPageSize(searchVO.getPageSize()); 					  	//아래 페이지 번호 몇개 줄 것인가
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setPageSize(paginationInfo.getPageSize());
		
		int recordCount = commonService.selectListTotCnt(searchVO, null, null, "noticeDAO.selectNoticeListCnt");
		paginationInfo.setTotalRecordCount(recordCount);
		
		List<NoticeVO> noticeVOList =  (List<NoticeVO>) commonService.selectList(searchVO, null, null, "noticeDAO.selectNoticeList");
		
		model.addAttribute("noticeVOList", noticeVOList);
		model.addAttribute("paginationInfo", paginationInfo); //notice_list에서 하단 페이지 번호 뿌려줄 수 있게 추가 
		model.addAttribute("searchVO", searchVO);
		
		return "/bbs/notice_list";
	}
	
	@RequestMapping("/bbs/notice_view.do")
	public String notice_view(NoticeVO searchVO, Model model) throws Exception {
		
		NoticeVO noticeVO = (NoticeVO) commonService.selectView(searchVO, null, null, "noticeDAO.selectNoticeView");
		
		model.addAttribute("noticeVO", noticeVO);
		return "/bbs/notice_view"; //뷰 반환
	}
	
	@RequestMapping("/bbs/notice_write.do")
	public String notice_write( Model model) throws Exception {
		model.addAttribute("mode", "write");
		return "/bbs/notice_write"; //뷰 반환
	}

	@RequestMapping("/bbs/notice_write_action.do")
	public String notice_write_action(NoticeVO noticeVO, HttpSession session, String mode) throws Exception {
		System.out.println("subject => " + noticeVO.getSubject());
		System.out.println("contents => " + noticeVO.getContents());
		
		//현재 로그인한 사람 정보 - 세션
		MemberVO loginVO = (MemberVO) session.getAttribute("login");  //로그인할 때 login으로 했음
		noticeVO.setWriter(loginVO.getName());	//멤버VO의 name을 작성자로 넣어주기
		
		// mode: write, modify
		if("write".equals(mode)) {
			//if(mode.equals("write")) 적으면 null일 때 문제가 생김
			//받은 데이터 삽입
			commonService.insert(noticeVO, null, null, "noticeDAO.insertNotice");
			
		} else {
			//update
			commonService.update(noticeVO, null, null, "noticeDAO.updateNotice");
		}
			
		return "redirect:/bbs/notice_list.do";	//같은 값 계속 안들어가게 하기위해 redirect로
	}	
	
	@RequestMapping("/bbs/notice_modify.do")
	public String notice_modify(NoticeVO searchVO, Model model) throws Exception{
		
		NoticeVO noticeVO = (NoticeVO) commonService.selectView(searchVO, null, null, "noticeDAO.selectNoticeView");
		//noticeVO 넘겨주기 위한 모델
		model.addAttribute("noticeVO", noticeVO);
		//data update -> write_action
		model.addAttribute("mode", "modify");
		return "/bbs/notice_write";	//이제 notice_write에 받은 값 뿌려주기
	}
}
