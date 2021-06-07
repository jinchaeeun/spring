package egovframework.com.cmm;

import egovframework.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ServletContextAware;
/**
 * ImagePaginationRenderer.java 클래스
 * 
 * @author 서준식
 * @since 2011. 9. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2011. 9. 16.   서준식       이미지 경로에 ContextPath추가
 * </pre>
 */
public class MyImagePaginationRenderer extends AbstractPaginationRenderer implements ServletContextAware{
	protected Log log = LogFactory.getLog(this.getClass());
	private ServletContext servletContext;
	
	public MyImagePaginationRenderer() {
	
	}
	//이미지 삭제, 선택된 페이지 번호 class='on' 설정
	public void initVariables(){
		firstPageLabel    = "<li>&#160;</li><li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">처음으로</a></li>";
        previousPageLabel = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">이전</a></li>";
        currentPageLabel  = "<li class='on'><a>{0}</a></li>";
        otherPageLabel    = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">{2}</a></li>";
        nextPageLabel     = "<li>&#160;<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">다음</a></li>";
        lastPageLabel     = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">마지막</a></li>";
	}

	

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		initVariables();
	}

}
