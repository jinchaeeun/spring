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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.com.cmm.service.CommonService;
import egovframework.com.cmm.util.EgovProperties;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import hustar.bbs.service.NoticeVO;
import hustar.member.service.MemberVO;
import hustar.page.util.FileUtil;

@Controller
public class NoticeController {	
	private static final String NOTICE_UPLOAD_PATH = EgovProperties.getProperty("Globals.fileStorePath") + "notice";
	
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
	public String notice_write( Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		//새 글쓰기 상태 - write, 수정은 modify
		model.addAttribute("mode", "write");
		
		//로그아웃 상태에서 글쓰기 저장 버튼 누르면
		MemberVO loginVO = (MemberVO) session.getAttribute("login");  //로그인할 때 login으로 했음
		if(loginVO == null) {
			redirectAttributes.addFlashAttribute("msg", "로그인이 필요합니다.");
			return "redirect:/member/login.do";
		}
		
		return "/bbs/notice_write"; //뷰 반환
	}

	@RequestMapping("/bbs/notice_write_action.do")
	public String notice_write_action(
			NoticeVO noticeVO, 
			HttpSession session, 
			String mode, 
			RedirectAttributes redirectAttributes,
			MultipartFile uploadFile) throws Exception {
		
		System.out.println("subject => " + noticeVO.getSubject());
		System.out.println("contents => " + noticeVO.getContents());
		
		//현재 로그인한 사람 정보 - 세션
		MemberVO loginVO = (MemberVO) session.getAttribute("login");  //로그인할 때 login으로 했음
		
		//로그아웃 상태에서 글쓰기 저장 버튼 누르면
		if(loginVO == null) {
			redirectAttributes.addFlashAttribute("msg", "로그인이 필요합니다.");
			return "redirect:/member/login.do";
		}
		
		noticeVO.setWriter(loginVO.getName());	//멤버VO의 name을 작성자로 넣어주기
		//첨부파일
		String filename = FileUtil.saveFile(uploadFile, NOTICE_UPLOAD_PATH);
		if(filename != null) {
			noticeVO.setFilename(filename);
			
			String oriFilename = filename.split("_")[1];
			noticeVO.setOriFilename(oriFilename);
		}
		
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
	
	@RequestMapping("/bbs/notice_delete.do")
	public String notice_delete(NoticeVO noticeVO) throws Exception{
		System.out.println("seq = " + noticeVO.getSeq());
		
		commonService.delete(noticeVO, null, null, "noticeDAO.deleteNotice");
		return "redirect:/bbs/notice_list.do";
	}
}
