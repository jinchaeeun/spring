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
import egovframework.com.test.service.TestService;
import egovframework.com.test.service.TestVO;

@Controller
@RequestMapping(value = {"/test", "/admin"})
public class TestController {
	protected Log log = LogFactory.getLog(getClass());

	@Resource(name="testService")
	TestService testService;

	@RequestMapping(value= {"/selectTestList.do", "/selectTest2List.do"})
	public String selectTestList(
			@ModelAttribute("searchVO") TestVO serchVO,
			HttpServletRequest req,
			HttpServletResponse res,
			ModelMap model
			) throws Exception {

		List<TestVO> resultList = (List<TestVO>)testService.selectList(serchVO, req, res);
		model.addAttribute("resultList", resultList);

		return "test/selectTestList";
	}

	@RequestMapping(value= {"/selectTestView.do"})
	public String selectTestView(
			@ModelAttribute("searchVO") TestVO searchVO,
			HttpServletRequest req,
			HttpServletResponse res,
			ModelMap model
			) throws Exception {
		log.debug("te_id="+searchVO.getTe_id());
		TestVO resultVO = (TestVO)testService.selectView(searchVO, req, res);
		model.addAttribute("resultVO", resultVO);

		return "test/selectTestView";
	}

	//      @RequestMapping(value= {"/insertTestForm.do"})
	//      public String insertTestForm(
	//        @ModelAttribute("searchVO") TestVO searchVO,
	//        HttpServletRequest req,
	//        HttpServletResponse res,
	//        ModelMap model
	//        ) throws Exception {
	//    	  model.addAttribute("actionUrl", "insertTest.do"); //actionUrl이라는 이름으로 insertTest.do 선언했음
	//  
	//    	 return "test/insertTestForm";
	//      }

	// 글쓰기 
	@RequestMapping(value= {"/insertTest{path1}.do"})
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
			log.debug("등록페이지 호출 :: insertTestForm.do");

			model.addAttribute("actionUrl", "insertTest.do");
			return "test/insertTestForm";

		} else if(path1 == null || "".equals(path1)) {
			//insertTest.do 호출(등록처리페이지)            
			log.debug("등록처리페이지 호출 :: insertTest.do");
			log.debug("te_name ::" + searchVO.getTe_name());
			log.debug("te_content ::"+ searchVO.getTe_content());

			try {
				// 데이터 저장
				String te_id = testService.insert(searchVO, req, res);
				model.addAttribute("resultMsg", "저장되었습니다.");
				model.addAttribute("retrunUrl", "/test/selectTestList.do");
				//log.debug("insert te_id ::: " + te_id);
			}catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("resultMsg", "저장에 실패하였습니다..");
			}
			//return "redirect:/test/selectTestView.do";
		}
		return "common/alert";
	}
	// 
	@RequestMapping(value= {"/updateTest{path1}.do"})
	public String updateTestForm(
			@PathVariable("path1") String path1,
			@ModelAttribute("searchVO") TestVO searchVO,
			HttpServletRequest req,
			HttpServletResponse res,
			ModelMap model
			) throws Exception {

		//폼이냐 저장페이지냐 나눠서 처리
		if("Form".equals(path1)) {
			//updateTestForm.do 호출(등록페이지)
			log.debug("수정페이지 호출 :: updateTestForm.do");

			//key 값 데이터 가져오기
			TestVO resultVO = (TestVO)testService.selectView(searchVO, req, res);
			model.addAttribute("resultVO", resultVO);

			model.addAttribute("actionUrl", "updateTest.do");
			return "test/insertTestForm"; //굳이 똑같은 페이지 만들 필요 없어서

		} else if(path1 == null || "".equals(path1)) {
			//insertTest.do 호출(등록처리페이지)            
			log.debug("등록처리페이지 호출 :: updateTest.do");
			log.debug("te_name ::" + searchVO.getTe_name());
			log.debug("te_content ::"+ searchVO.getTe_content());

			try {
				// 데이터 저장
				//String te_id = testService.update(searchVO, req, res);

				model.addAttribute("resultMsg", "저장되었습니다.");
				model.addAttribute("retrunUrl", "/test/selectTestList.do");
				//log.debug("insert te_id ::: " + te_id);
			}catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("resultMsg", "저장에 실패하였습니다..");
			}
			//return "redirect:/test/selectTestView.do";
		}
		return "common/alert";
	}
}