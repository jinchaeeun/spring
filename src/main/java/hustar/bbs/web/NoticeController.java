package hustar.bbs.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.service.CommonService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import hustar.bbs.service.NoticeVO;

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
	
}
