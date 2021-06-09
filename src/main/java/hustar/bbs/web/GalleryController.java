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
import hustar.bbs.service.GalleryVO;
import hustar.member.service.MemberVO;
import hustar.page.util.FileUtil;

@Controller
public class GalleryController {	
	private static final String GALLERY_UPLOAD_PATH = EgovProperties.getProperty("Globals.fileStorePath") + "gallery";
	
	@Resource(name="commonService") 
	CommonService commonService;

	@Resource(name="jsonView")
	MappingJackson2JsonView jsonView;
	
	
	@RequestMapping("/bbs/gallery_list.do")
	public String gallery_list(GalleryVO searchVO, Model model) throws Exception {
		
		List<GalleryVO> galleryVOList = (List<GalleryVO>) commonService.selectList(searchVO, null, null, "galleryDAO.selectGalleryList");
		
		model.addAttribute("galleryVOList", galleryVOList);
		
		return "/bbs/gallery_list";
	}
	
	@RequestMapping("/bbs/gallery_view.do")
	public String gallery_view(GalleryVO searchVO, Model model) throws Exception{
		
		GalleryVO galleryVO = (GalleryVO) commonService.selectView(searchVO, null, null, "galleryDAO.selectGalleryView");
		
		model.addAttribute("galleryVO", galleryVO);
		
		return "/bbs/gallery_view";
	}
	
	@RequestMapping("/bbs/gallery_modify.do")
	public String gallery_modify(GalleryVO searchVO, Model model) throws Exception{
		
		GalleryVO galleryVO = (GalleryVO) commonService.selectView(searchVO, null, null, "galleryDAO.selectGalleryView");
		
		//galleryVO 넘겨주기 위한 모델
		model.addAttribute("galleryVO", galleryVO);
		
		//data update -> write_action
		model.addAttribute("mode", "modify");
		return "/bbs/gallery_write";
	}
	
	@RequestMapping("/bbs/gallery_write.do")
	public String gallery_write( Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		//새 글쓰기 상태 - write, 수정은 modify
		model.addAttribute("mode", "write");
		
		//로그아웃 상태에서 글쓰기 저장 버튼 누르면
		MemberVO loginVO = (MemberVO) session.getAttribute("login");  //로그인할 때 login으로 했음
		if(loginVO == null) {
			redirectAttributes.addFlashAttribute("msg", "로그인이 필요합니다.");
			return "redirect:/member/login.do";
		}
		
		return "/bbs/gallery_write"; //뷰 반환
	}
	
	@RequestMapping("/bbs/gallery_write_action.do")
	public String gallery_write_action(
			GalleryVO galleryVO, 
			HttpSession session, 
			String mode, 
			RedirectAttributes redirectAttributes,
			MultipartFile uploadFile) throws Exception {
		
		System.out.println("subject => " + galleryVO.getSubject());
		System.out.println("contents => " + galleryVO.getContents());
		
		//현재 로그인한 사람 정보 - 세션
		MemberVO loginVO = (MemberVO) session.getAttribute("login");  //로그인할 때 login으로 했음
		
		//로그아웃 상태에서 글쓰기 저장 버튼 누르면
		if(loginVO == null) {
			redirectAttributes.addFlashAttribute("msg", "로그인이 필요합니다.");
			return "redirect:/member/login.do";
		}
		
		galleryVO.setWriter(loginVO.getName());	//멤버VO의 name을 작성자로 넣어주기
		//첨부파일 ex)uuid_원래 파일명, 원래파일명을 보여주기 위해 _ 분리
		String filename = FileUtil.saveFile(uploadFile, GALLERY_UPLOAD_PATH);
		if(filename != null) {
			galleryVO.setFilename(filename);
			
			String oriFilename = filename.split("_")[1];	//구분기호 잘라주기
			galleryVO.setOriFilename(oriFilename);
		}
		
		// mode: write, modify
		if("write".equals(mode)) {
			//if(mode.equals("write")) 적으면 null일 때 문제가 생김
			//받은 데이터 삽입
			commonService.insert(galleryVO, null, null, "galleryDAO.insertGallery");
			
		} else {
			//update
			commonService.update(galleryVO, null, null, "galleryDAO.updateGallery");
		}
			
		return "redirect:/bbs/gallery_list.do";	//같은 값 계속 안들어가게 하기위해 redirect로
	}	
	
	@RequestMapping("/bbs/gallery_delete.do")
	public String gallery_delete(GalleryVO galleryVO) throws Exception{
		System.out.println("seq = " + galleryVO.getSeq());
		
		commonService.delete(galleryVO, null, null, "galleryDAO.deleteGallery");
		return "redirect:/bbs/gallery_list.do";
	}
	
	@RequestMapping("/bbs/gallery_downloadFile.do")
	public void gallery_downloadFile(
			GalleryVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		GalleryVO galleryVO = (GalleryVO) commonService.selectView(searchVO, null, null, "galleryDAO.selectGalleryView");
		//file 저장여부
		String filename = galleryVO.getFilename();
		if(filename == null) {
			return;
		}
		
		String filePath = GALLERY_UPLOAD_PATH + "/" + galleryVO.getFilename(); //실제경로
		
		FileUtil.downFile(request, response, filePath, galleryVO.getOriFilename());
	}
	
	@RequestMapping("/bbs/gallery_deleteFile.do")
	public ModelAndView gallery_deleteFile(GalleryVO searchVO, Model model) throws Exception{
		
		GalleryVO fileVO = (GalleryVO) commonService.selectView(searchVO, null, null, "galleryDAO.selectGalleryView");
		
		String filePath = GALLERY_UPLOAD_PATH + "/" + fileVO.getFilename();
		
		if(FileUtil.deleteFile(filePath) == true) {
			GalleryVO galleryVO = new GalleryVO();
			galleryVO.setSeq(searchVO.getSeq());
			galleryVO.setFilename("");
			galleryVO.setOriFilename("");
			commonService.update(galleryVO, null, null, "galleryDAO.updateGallery");
			
			model.addAttribute("success", "true");
		} else {
			model.addAttribute("success", "false");
		}
		return new ModelAndView(jsonView);
		
	}
	
	@RequestMapping("/bbs/gallery_image.do")
	public void gallery_image(GalleryVO searchVO, HttpServletResponse response) throws Exception{
		
		GalleryVO galleryVO = (GalleryVO) commonService.selectView(searchVO, null, null, "galleryDAO.selectGalleryView");
		
		FileUtil.displayImage(response, GALLERY_UPLOAD_PATH, galleryVO.getFilename());
	}
}