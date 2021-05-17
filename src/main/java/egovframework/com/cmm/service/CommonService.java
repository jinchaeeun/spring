package egovframework.com.cmm.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;



/**
 * 
 * @author Administrator
 *
 */
public interface CommonService{
	/**
	 *  목록 페이지
	 * @param searchVO 검색조건
	 * @return List<ComDefaultVO> 게시판 정보
	 * @throws Exception
	 */
	public List<?> selectList(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	/**
	 *  목록 페이지
	 * @param searchVO 검색조건
	 * @return List<ComDefaultVO> 게시판 정보
	 * @throws Exception
	 */
	public List<?> selectList(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception;
	
	/**
	 *  목록 페이지
	 * @param searchVO 검색조건
	 * @return List<ComDefaultVO> 게시판 정보
	 * @throws Exception
	 */
	public List<?> selectList(HashMap<String,Object> searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception;
	
	/**
	 *   목록  갯수
	 * @param searchVO 검색조건
	 * @return List<ComDefaultVO> 게시판 정보
	 * @throws Exception
	 */
	public int selectListTotCnt(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	/**
	 *   목록  갯수
	 * @param searchVO 검색조건
	 * @return List<ComDefaultVO> 게시판 정보
	 * @throws Exception
	 */
	public int selectListTotCnt(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception;
	
	/**
	 *   목록  갯수
	 * @param searchVO 검색조건
	 * @return List<ComDefaultVO> 게시판 정보
	 * @throws Exception
	 */
	public int selectListTotCnt(HashMap<String,Object> searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception;
	
	/**
	 *   데이터 등록
	 * @param CodeVO 게시판 데이터
	 * @return String 등록결과
	 * @throws Exception
	 */
	public String insert(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	/**
	 * 등록
	 */
	public String insert(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception;
	
	/**
	 * 등록
	 */
	public String insert(HashMap<String,Object> searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception;
	
	/**
	 *   데이터 조회
	 * @param CodeVO 조회 키값
	 * @return String 게시판 데이터
	 * @throws Exception
	*/ 
	public ComDefaultVO selectView(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	/**
	 * 상세
	 */
	public ComDefaultVO selectView(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception;
	
	/**
	 * 상세
	 */
	public HashMap<String,Object> selectView(HashMap<String,Object> searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception;
	
	/**
	 *   데이터 수정
	 * @param CodeVO 게시판 데이터
	 * @return String 등록결과
	 * @throws Exception
	*/
	public int update(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	/**
	 * 수정
	 */
	public int update(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res, String sql_id) throws Exception;
	
	/**
	 *   데이터 삭제
	 * @param CodeVO 게시판 데이터
	 * @return int
	 * @throws Exception
	*/ 
	public int delete(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res) throws Exception;
			
	/**
	 * 삭제
	 * @param searchVO
	 * @param req
	 * @param res
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int delete(ComDefaultVO searchVO,HttpServletRequest req, HttpServletResponse res, String sql) throws Exception;
	
	
	/**
	 * 현재 Context 넘겨준다.
	 * @param searchVO 검색조건
	 * @return String
	 * @throws Exception
	 */
	public String getContextPath() throws Exception;
	
	/**
	 * 현재 Context의 절대경로를 넘겨준다.
	 * @param searchVO 검색조건
	 * @return String
	 * @throws Exception
	 */
	public String getRealPath() throws Exception;
	
	/**
	 * 도메인을 넘겨준다.
	 * @param searchVO 검색조건
	 * @return String
	 * @throws Exception
	 */
	public String getServerName() throws Exception;
	
	/**
	 * 포트을 넘겨준다.
	 * @param searchVO 검색조건
	 * @return String
	 * @throws Exception
	 */
	public int getServerPort() throws Exception;
	
	/**
	 * 해당 MenuId에 대하여 메뉴정보를 조회하여 searchVO에 파라메터를 셋팅하고 페이징 변수, 로컬 파라메터 등을 셋팅한다.
	 * @param searchVO
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	
}
