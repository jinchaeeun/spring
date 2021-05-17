package egovframework.com.cmm.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.service.CommonService;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * 공통 관리
 * @author Administrator
 *
 */
@Controller
public class CommonController {
	/** Log Info */
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	@Resource(name="propertiesService")
	private EgovPropertyService propertiesService;
	

	
	/**
	 * 일반 페이지 1 depth 보이기
	 * @param var1
	 * @param var2
	 * @param req
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/{var1}.do")
	public String selectView(
			@ModelAttribute("searchVO") ComDefaultVO searchVO,
			@PathVariable("var1") String var1,
			HttpServletRequest req ,
			ModelMap model
			) throws Exception {
			
		return var1;
	}
	
    /**
	 * 일반 페이지 2 depth 보이기
	 * @param var1
	 * @param var2
	 * @param req
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/{var1}/{var2}.do")
	public String selectView2(@ModelAttribute("searchVO") ComDefaultVO searchVO,@PathVariable("var1") String var1,@PathVariable("var2") String var2,HttpServletRequest req ,ModelMap model) throws Exception {
				
		return var1+"/"+var2;
	}
	
	/**
	 * 일반 페이지 3 depth 보이기
	 * @param var1
	 * @param var2
	 * @param req
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/{var1}/{var2}/{var3}.do")
    public String selectView3(@ModelAttribute("searchVO") ComDefaultVO searchVO,@PathVariable("var1") String var1,@PathVariable("var2") String var2,@PathVariable("var3") String var3,
    		HttpServletRequest req ,ModelMap model) throws Exception {
		
		return var1+"/"+var2+"/"+var3;
	}

    
        
    
    
}
