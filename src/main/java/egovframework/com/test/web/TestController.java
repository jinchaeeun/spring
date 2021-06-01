package egovframework.com.test.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.ImagePaginationInfo;
import egovframework.com.cmm.service.CommonService;
import egovframework.com.test.service.TestService;
import egovframework.com.test.service.TestVO;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
@RequestMapping(value = {"/test", "/admin"})
public class TestController {
	protected Log log = LogFactory.getLog(getClass());

	@Resource(name="testService")
	TestService testService;
	
	@Resource(name="commonService")
	CommonService commonService;

	@Resource(name="propertiesService")
	EgovPropertyService propertiesService;

	@RequestMapping(value= {"/selectTestList.do", "/selectTest2List.do"})
	public String selectTestList(
			@ModelAttribute("searchVO") TestVO searchVO,
			HttpServletRequest req,
			HttpServletResponse res,
			ModelMap model
			) throws Exception {
		//전체 count
		int totCnt = commonService.selectListTotCnt(searchVO, req, res, "testDAO.selectTestListTotCnt");
		//한 페이지 row수
		//searchVO.setPageUnit(3);
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		//page 노출갯수
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		//페이징 선언
		ImagePaginationInfo paginationInfo = new ImagePaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		paginationInfo.setTotalRecordCount(totCnt);

		//select 할 때 필요한 limit 값 세팅
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<TestVO> resultList = (List<TestVO>)commonService.selectList(searchVO, req, res, "testDAO.selectTestList");
		List<TestVO> noticeList = (List<TestVO>)commonService.selectList(searchVO, req, res, "testDAO.selectTestNoticeList");
		
		log.debug("te_is_best :: " + searchVO.getTe_is_best());
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("paginationInfo", paginationInfo.getPagingHtml("fn_paging")); //html 가져오려면 paginationInfo.getPagingHtml("fn_paging"); //함수명 호출
		model.addAttribute("totCnt", totCnt);

		return "test/selectTestList";
	}
	
	@RequestMapping(value = {"/selectTestView.do"})
	public String selectTestView(
			@ModelAttribute("searchVO") TestVO searchVO,
			HttpServletRequest req,
			HttpServletResponse res,
			ModelMap model
			) throws Exception {
			log.debug("te_id="+searchVO.getTe_id());
			
			//TestVO resultVO = (TestVO)testService.selectView(searchVO, req, res);
			//이렇게 쓰면 DAO 만들 필요 없이 그냥 사용 가능
			TestVO resultVO = (TestVO)commonService.selectView(searchVO, req, res, "testDAO.selectTestView");
			model.addAttribute("resultVO", resultVO);
			
		return "test/selectTestView";
	}
	
	@RequestMapping(value = {"/insertTest{path1}.do"})
	public String insertTestForm(
			@PathVariable("path1") String path1,
			@ModelAttribute("searchVO") TestVO searchVO,
			HttpServletRequest req,
			HttpServletResponse res,
			ModelMap model
			) throws Exception {
			
				//폼이냐 저장페이지냐 나눠서 처리
			if("Form".equals(path1)) {
				//insertTestForm.do 호출(등록페이지)
				log.debug("등록페이지호출 :: insertTestForm.do");
				
				model.addAttribute("actionUrl", "insertTest.do");
				return "test/insertTestForm";
				
			}else if(path1 == null || "".equals(path1)) {
				//insertTest.do 호출(등록처리페이지)
				log.debug("등록처리페이지호출 :: insertTest.do");
				log.debug("te_name :: " + searchVO.getTe_name());
				log.debug("te_content :: " + searchVO.getTe_content());
				
				try {
					//데이터 저장(insert)
					//String te_id = testService.insert(searchVO, req, res);
					String te_id = commonService.insert(searchVO, req, res, "testDAO.insertTest");
					
					model.addAttribute("resultMsg", "저장되었습니다.");
					model.addAttribute("returnUrl", "/test/selectTestList.do");
				}catch(Exception e) {
					e.printStackTrace();
					model.addAttribute("resultMsg", "저장에 실패하였습니다.");
				}
				
				
				//return "redirect:/test/selectTestList.do";
			}

			return "common/alert";
	}
	
	
	
	@RequestMapping(value = {"/updateTest{path1}.do"})
	public String updateTestForm(
			@PathVariable("path1") String path1,
			@ModelAttribute("searchVO") TestVO searchVO,
			HttpServletRequest req,
			HttpServletResponse res,
			ModelMap model
			) throws Exception {
		
			if("Form".equals(path1)) {
				//updateTestForm.do 호출(등록페이지)
				log.debug("수정페이지호출 :: updateTestForm.do");
				
				//key값 데이터 가져오기
				TestVO resultVO = (TestVO)testService.selectView(searchVO, req, res);
				model.addAttribute("resultVO", resultVO);
				
				model.addAttribute("actionUrl", "updateTest.do");
				return "test/insertTestForm"; //굳이 똑같은 페이지 만들 필요 없어서
				
			}else if(path1 == null || "".equals(path1)) {
				//updateTest.do 호출(등록처리페이지)
				log.debug("등록처리페이지호출 :: updateTest.do");
				log.debug("te_name :: " + searchVO.getTe_name());
				log.debug("te_content :: " + searchVO.getTe_content());
				
				try {
					//데이터 저장(update)
					//testService.update(searchVO, req, res);
					commonService.update(searchVO, req, res, "testDAO.updateTest");
					
					model.addAttribute("resultMsg", "수정되었습니다.");
					model.addAttribute("returnUrl", "/test/selectTestList.do");
				}catch(Exception e) {
					e.printStackTrace();
					model.addAttribute("resultMsg", "수정에 실패하였습니다.");
				}
				
				
				//return "redirect:/test/selectTestList.do";
			}

			return "common/alert";
		
			
		
	}
	
	@RequestMapping(value = {"/deleteTest.do"})
	public String deleteTest(
			@ModelAttribute("searchVO") TestVO searchVO,
			HttpServletRequest req,
			HttpServletResponse res,
			ModelMap model
			) throws Exception {
		
			//deleteTest.do 호출(삭제처리페이지)
			log.debug("삭제처리페이지호출 :: deleteTest.do");
			log.debug("te_id :: " + searchVO.getTe_id());
			
			try {
				//데이터 삭제(delete)
				//testService.delete(searchVO, req, res);
				commonService.delete(searchVO, req, res, "testDAO.deleteTest");
				
				model.addAttribute("resultMsg", "삭제되었습니다.");
				model.addAttribute("returnUrl", "/test/selectTestList.do");
			}catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("resultMsg", "삭제에 실패하였습니다.");
			}

			return "common/alert";
	}
	
	@RequestMapping(value = {"/deleteTestAll.do"})
	public String deleteTestAll(
			@ModelAttribute("searchVO") TestVO searchVO,
			HttpServletRequest req,
			HttpServletResponse res,
			ModelMap model
			) throws Exception {
		
			//deleteTest.do 호출(삭제처리페이지)
			log.debug("선택삭제처리페이지호출 :: deleteTestAll.do");

			log.debug("test :: " + req.getParameter("te_ids"));

			
			try {
				//데이터 삭제(delete)
				if(searchVO.getTe_ids() != null) {
					for(int i = 0; i < searchVO.getTe_ids().length; i++) {
						//log.debug("te_id ::: " + searchVO.getTe_ids()[i]);
						searchVO.setTe_id(searchVO.getTe_ids()[i]);
						commonService.delete(searchVO, req, res, "testDAO.deleteTest");
					}
				}
				
				model.addAttribute("resultMsg", "선택된 데이터가 삭제되었습니다.");
				model.addAttribute("returnUrl", "/test/selectTestList.do");
			}catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("resultMsg", "삭제에 실패하였습니다.");
			}

			return "common/alert";
	}
}
