package egovframework.com.cmm.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.service.CommonService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.property.EgovPropertyService;


/**
 * 공통서비스 
 */
@Service("commonService")
public class CommonServiceImpl extends EgovAbstractServiceImpl implements CommonService {
	
	/** Log Info */
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Resource(name = "commonDAO")
	private CommonDAO commonDAO;
	
	
	
	@Resource(name="propertiesService")
	private EgovPropertyService propertiesService;
	
	
	/**
	 * 목록
	 */
	public List<?> selectList(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception {
		return this.selectList(searchVO, req, res, searchVO.getLoc_enm().toLowerCase()+"DAO.select"+searchVO.getLoc_enm()+"List");
	}
	
	/**
	 * 목록
	 */
	public List<?> selectList(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res,String sql_id) throws Exception {
		 return commonDAO.selectList(searchVO,sql_id);
	}
	
	/**
	 * 목록
	 */
	public List<?> selectList(HashMap<String,Object> searchVO,HttpServletRequest req, HttpServletResponse res,String sql_id) throws Exception {
		 return commonDAO.selectList(searchVO,sql_id);
	}
	
	/**
	 * 개수 조회
	 */
	public int selectListTotCnt(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception {
		return this.selectListTotCnt(searchVO, req, res, searchVO.getLoc_enm().toLowerCase()+"DAO.select"+searchVO.getLoc_enm()+"ListTotCnt");
	}
	
	/**
	 * 개수 조회
	 */
	public int selectListTotCnt(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res,String sql_id) throws Exception {
		return commonDAO.selectListTotCnt(searchVO, sql_id);
	}
	
	/**
	 * 개수 조회
	 */
	public int selectListTotCnt(HashMap<String,Object> searchVO,HttpServletRequest req, HttpServletResponse res,String sql_id) throws Exception {
		return commonDAO.selectListTotCnt(searchVO, sql_id);
	}
	
	/**
	 * 등록
	 */
	public String insert(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("---------------" + searchVO.getLoc_enm().toLowerCase()+"DAO.insert"+searchVO.getLoc_enm());
		return this.insert(searchVO, req, res, searchVO.getLoc_enm().toLowerCase()+"DAO.insert"+searchVO.getLoc_enm());
	}
	
	/**
	 * 등록
	 */
	public String insert(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception{	
		
		
		String result = commonDAO.insert(searchVO, sql_id);
		
		return result;
	}
	
	/**
	 * 등록
	 */
	public String insert(HashMap<String,Object> searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception{
		
		//해당되는 것만 캐쉬삭제함.
//		this.deleteRedis((String)searchVO.get("loc_enm"));
				
		
		String result = commonDAO.insert(searchVO, sql_id);
		
		return result;
	}
	
	/**
	 * 상세
	 */
	public ComDefaultVO selectView(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception{
//		return (ComDefaultVO)commonDAO.selectView(searchVO, searchVO.getLoc_enm().toLowerCase()+"DAO.select"+searchVO.getLoc_enm()+"View");
		return this.selectView(searchVO, req, res, searchVO.getLoc_enm().toLowerCase()+"DAO.select"+searchVO.getLoc_enm()+"View");
	}
	
	/**
	 * 상세
	 */
	public ComDefaultVO selectView(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception{
		System.out.println(sql_id);
		return (ComDefaultVO)commonDAO.selectView(searchVO, sql_id);
	}
	
	/**
	 * 상세
	 */
	public HashMap<String,Object> selectView(HashMap<String,Object> searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception{
		return (HashMap<String,Object>)commonDAO.selectView(searchVO, sql_id);
	}
	
	/**
	 * 수정
	 */
	public int update(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println(searchVO.getLoc_enm().toLowerCase()+"DAO.update"+searchVO.getLoc_enm());
		int result = this.update(searchVO, req, res, searchVO.getLoc_enm().toLowerCase()+"DAO.update"+searchVO.getLoc_enm());
				
		return result;
	}
	
	/**
	 * 수정
	 */
	public int update(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception{
		
		//해당되는 것만 캐쉬삭제함.
//		this.deleteRedis(searchVO.getLoc_enm());
		
		
		int result = commonDAO.update(searchVO, sql_id);
		
		
		
		return result;
	}
	
	/**
	 * 삭제
	 */
	public int delete(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		int result = this.delete(searchVO, req, res, searchVO.getLoc_enm().toLowerCase()+"DAO.delete"+searchVO.getLoc_enm());
		
		return result;
	}
	
	/**
	 * 삭제
	 */
	public int delete(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res,String sql_id) throws Exception{
		
		int result = commonDAO.delete(searchVO, sql_id);
		
		
		
		return result;
	}
	
	
	
	/**
	 * 현재 Context 넘겨준다.
	 * @param searchVO 검색조건
	 * @return List<ComDefaultCodeVO> 게시판 정보
	 * @throws Exception
	 */
	public String getContextPath() throws Exception{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String contextPath = attr.getRequest().getContextPath();
		
		return contextPath;
	}
	
	/**
	 * 현재 Context의 절대경로를 넘겨준다.
	 * @param searchVO 검색조건
	 * @return List<ComDefaultCodeVO> 게시판 정보
	 * @throws Exception
	 */
	public String getRealPath() throws Exception{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String contextPath = attr.getRequest().getSession().getServletContext().getRealPath("/");		
		if(contextPath != null){
			try{
				if(contextPath.length() > 3){
					contextPath = contextPath.substring(0, contextPath.length()-1);					
				}			
			}catch(Exception ex){ex.printStackTrace();}
		}
		return contextPath;
	}
	
	
	
	/**
	 * 도메인을 넘겨준다.
	 * @param searchVO 검색조건
	 * @return List<ComDefaultCodeVO> 게시판 정보
	 * @throws Exception
	 */
	public String getServerName() throws Exception{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String contextPath = attr.getRequest().getServerName();
		return contextPath;
	}
	
	/**
	 * 포트을 넘겨준다.
	 * @param searchVO 검색조건
	 * @return List<ComDefaultCodeVO> 게시판 정보
	 * @throws Exception
	 */
	public int getServerPort() throws Exception{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		int contextPath = attr.getRequest().getServerPort();
		return contextPath;
	}
	
	
}
