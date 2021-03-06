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
		
		//galleryVO ???????????? ?????? ??????
		model.addAttribute("galleryVO", galleryVO);
		
		//data update -> write_action
		model.addAttribute("mode", "modify");
		return "/bbs/gallery_write";
	}
	
	@RequestMapping("/bbs/gallery_write.do")
	public String gallery_write( Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		//??? ????????? ?????? - write, ????????? modify
		model.addAttribute("mode", "write");
		
		//???????????? ???????????? ????????? ?????? ?????? ?????????
		MemberVO loginVO = (MemberVO) session.getAttribute("login");  //???????????? ??? login?????? ??????
		if(loginVO == null) {
			redirectAttributes.addFlashAttribute("msg", "???????????? ???????????????.");
			return "redirect:/member/login.do";
		}
		
		return "/bbs/gallery_write"; //??? ??????
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
		
		//?????? ???????????? ?????? ?????? - ??????
		MemberVO loginVO = (MemberVO) session.getAttribute("login");  //???????????? ??? login?????? ??????
		
		//???????????? ???????????? ????????? ?????? ?????? ?????????
		if(loginVO == null) {
			redirectAttributes.addFlashAttribute("msg", "???????????? ???????????????.");
			return "redirect:/member/login.do";
		}
		
		galleryVO.setWriter(loginVO.getName());	//??????VO??? name??? ???????????? ????????????
		//???????????? ex)uuid_?????? ?????????, ?????????????????? ???????????? ?????? _ ??????
		String filename = FileUtil.saveFile(uploadFile, GALLERY_UPLOAD_PATH);
		if(filename != null) {
			galleryVO.setFilename(filename);
			
			String oriFilename = filename.split("_")[1];	//???????????? ????????????
			galleryVO.setOriFilename(oriFilename);
		}
		
		// mode: write, modify
		if("write".equals(mode)) {
			//if(mode.equals("write")) ????????? null??? ??? ????????? ??????
			//?????? ????????? ??????
			commonService.insert(galleryVO, null, null, "galleryDAO.insertGallery");
			
		} else {
			//update
			commonService.update(galleryVO, null, null, "galleryDAO.updateGallery");
		}
			
		return "redirect:/bbs/gallery_list.do";	//?????? ??? ?????? ??????????????? ???????????? redirect???
	}	
	
	@RequestMapping("/bbs/gallery_delete.do")
	public String gallery_delete(GalleryVO searchVO, HttpSession session, RedirectAttributes redirectAttributes) throws Exception{
		//System.out.println("seq = " + searchVO.getSeq());
		
		//?????? ???????????? ?????? ?????? - ??????
		MemberVO loginVO = (MemberVO) session.getAttribute("login");  //???????????? ??? login?????? ??????
		
		//???????????? ???????????? ????????? ?????? ?????? ?????????
		if(loginVO == null) {
			redirectAttributes.addFlashAttribute("msg", "???????????? ???????????????.");
			return "redirect:/member/login.do";
		}else {
			System.out.println("gallery_delete");
			//?????? ??????
			GalleryVO fileVO = (GalleryVO) commonService.selectView(searchVO, null, null, "galleryDAO.selectGalleryView");
			String filePath = GALLERY_UPLOAD_PATH +"/" + fileVO.getFilename(); 
			FileUtil.deleteFile(filePath);
			System.out.println("filePath => " + filePath);
			//??????
			commonService.delete(searchVO, null, null, "galleryDAO.deleteGallery");
			
		}
		
		return "redirect:/bbs/gallery_list.do";
	}
	
	@RequestMapping("/bbs/gallery_downloadFile.do")
	public void gallery_downloadFile(
			GalleryVO searchVO,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		GalleryVO galleryVO = (GalleryVO) commonService.selectView(searchVO, null, null, "galleryDAO.selectGalleryView");
		//file ????????????
		String filename = galleryVO.getFilename();
		System.out.println("filename => " +filename);
		if(filename == null) {
			return;
		}
		
		String filePath = GALLERY_UPLOAD_PATH + "/" + galleryVO.getFilename(); //????????????
		
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