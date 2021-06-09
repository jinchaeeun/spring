package hustar.bbs.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import egovframework.com.cmm.service.CommonService;
import egovframework.com.cmm.util.EgovProperties;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import hustar.bbs.service.NoticeVO;
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
	public String gallery_list() throws Exception {
		return "/bbs/gallery_list";
	}
}