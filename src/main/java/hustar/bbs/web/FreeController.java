package hustar.bbs.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import egovframework.com.cmm.service.CommonService;
import egovframework.com.cmm.util.EgovProperties;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import hustar.bbs.service.FreeVO;
import hustar.member.service.MemberVO;
import hustar.page.util.FileUtil;

@Controller
public class FreeController {	
	private static final String FREE_UPLOAD_PATH = EgovProperties.getProperty("Globals.fileStorePath") + "free";
	
	@Resource(name="commonService") 
	CommonService commonService;

	@Resource(name="jsonView")
	MappingJackson2JsonView jsonView;
	
	
	@RequestMapping("/bbs/free_list.do")
	public String free_list(FreeVO searchVO, Model model) throws Exception {
		
		//검색 값 가져오는 지 확인
		System.out.println("searchKeyword = " + searchVO.getSearchKeyword());
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getRecordCountPerPage()); 	//한 페이지 당 몇개 표시
		paginationInfo.setPageSize(searchVO.getPageSize()); 					  	//아래 페이지 번호 몇개 줄 것인가
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setPageSize(paginationInfo.getPageSize());
		
		int recordCount = commonService.selectListTotCnt(searchVO, null, null, "freeDAO.selectFreeListCnt");
		paginationInfo.setTotalRecordCount(recordCount);
		
		List<FreeVO> freeVOList = (List<FreeVO>) commonService.selectList(searchVO, null, null, "freeDAO.selectFreeList");
		
		model.addAttribute("freeVOList", freeVOList);
		model.addAttribute("paginationInfo", paginationInfo); //notice_list에서 하단 페이지 번호 뿌려줄 수 있게 추가 
		model.addAttribute("searchVO", searchVO);
		
		return "/bbs/free_list";
	}
	
	@RequestMapping("/bbs/free_view.do")
	public String free_view(FreeVO searchVO, Model model) throws Exception{
		
		FreeVO freeVO = (FreeVO) commonService.selectView(searchVO, null, null, "freeDAO.selectFreeView");
		
		model.addAttribute("freeVO", freeVO);
		
		return "/bbs/free_view";
	}
	
	@RequestMapping("/bbs/free_write.do")
	public String free_write( Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		//새 글쓰기 상태 - write, 수정은 modify
		model.addAttribute("mode", "write");
		
		//로그아웃 상태에서 글쓰기 저장 버튼 누르면
		MemberVO loginVO = (MemberVO) session.getAttribute("login");  //로그인할 때 login으로 했음
		if(loginVO == null) {
			redirectAttributes.addFlashAttribute("msg", "로그인이 필요합니다.");
			return "redirect:/member/login.do";
		}
		
		return "/bbs/free_write"; //뷰 반환
	}
	
	@RequestMapping("/bbs/free_write_action.do")
	public String free_write_action(
			FreeVO freeVO, 
			HttpSession session, 
			String mode, 
			RedirectAttributes redirectAttributes,
			MultipartFile uploadFile) throws Exception {
		
		System.out.println("subject => " + freeVO.getSubject());
		System.out.println("contents => " + freeVO.getContents());
		
		//현재 로그인한 사람 정보 - 세션
		MemberVO loginVO = (MemberVO) session.getAttribute("login");  //로그인할 때 login으로 했음
		
		//로그아웃 상태에서 글쓰기 저장 버튼 누르면
		if(loginVO == null) {
			redirectAttributes.addFlashAttribute("msg", "로그인이 필요합니다.");
			return "redirect:/member/login.do";
		}
		
		freeVO.setWriter(loginVO.getName());	//멤버VO의 name을 작성자로 넣어주기
		//첨부파일 ex)uuid_원래 파일명, 원래파일명을 보여주기 위해 _ 분리
		String filename = FileUtil.saveFile(uploadFile, FREE_UPLOAD_PATH);
		if(filename != null) {
			freeVO.setFilename(filename);
			
			String oriFilename = filename.split("_")[1];	//구분기호 잘라주기
			freeVO.setOriFilename(oriFilename);
		}
		
		// mode: write, modify
		if("write".equals(mode)) {
			//if(mode.equals("write")) 적으면 null일 때 문제가 생김
			//받은 데이터 삽입
			commonService.insert(freeVO, null, null, "freeDAO.insertFree");
			
		} else {
			//update
			commonService.update(freeVO, null, null, "freeDAO.updateFree");
		}
			
		return "redirect:/bbs/free_list.do";	//같은 값 계속 안들어가게 하기위해 redirect로
	}	
	
	@RequestMapping("/bbs/free_modify.do")
	public String free_modify(FreeVO searchVO, Model model) throws Exception{
		
		FreeVO freeVO = (FreeVO) commonService.selectView(searchVO, null, null, "freeDAO.selectFreeView");
		
		//freeVO 넘겨주기 위한 모델
		model.addAttribute("freeVO", freeVO);
		
		//data update -> write_action
		model.addAttribute("mode", "modify");
		return "/bbs/free_write";
	}
	
	@RequestMapping("/bbs/free_delete.do")
	public String free_delete(FreeVO freeVO) throws Exception{
		System.out.println("seq = " + freeVO.getSeq());
		
		commonService.delete(freeVO, null, null, "freeDAO.deleteFree");
		return "redirect:/bbs/free_list.do";
	}
	
	@RequestMapping("/bbs/free_downloadFile.do")
	public void free_downloadFile(
			FreeVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		FreeVO freeVO = (FreeVO) commonService.selectView(searchVO, null, null, "freeDAO.selectFreeView");
		//file 저장여부
		String filename = freeVO.getFilename();
		if(filename == null) {
			return;
		}
		
		String filePath = FREE_UPLOAD_PATH + "/" + freeVO.getFilename(); //실제경로
		
		FileUtil.downFile(request, response, filePath, freeVO.getOriFilename());
	}
	
	@RequestMapping("/bbs/free_deleteFile.do")
	public ModelAndView free_deleteFile(FreeVO searchVO, Model model) throws Exception{
		
		FreeVO fileVO = (FreeVO) commonService.selectView(searchVO, null, null, "freeDAO.selectFreeView");
		
		String filePath = FREE_UPLOAD_PATH + "/" + fileVO.getFilename();
		
		if(FileUtil.deleteFile(filePath) == true) {
			FreeVO freeVO = new FreeVO();
			freeVO.setSeq(searchVO.getSeq());
			freeVO.setFilename("");
			freeVO.setOriFilename("");
			commonService.update(freeVO, null, null, "freeDAO.updateFree");
			
			model.addAttribute("success", "true");
		} else {
			model.addAttribute("success", "false");
		}
		return new ModelAndView(jsonView);
		
	}
}