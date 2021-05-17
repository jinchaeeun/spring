package egovframework.com.cmm.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.ComDefaultVO;

/**
 * 공통 DAO
 * @author Administrator
 *
 */
@Repository("commonDAO")
public class CommonDAO extends MainDAO {

	/**
	 * 목록
	 * @param userSearchVO 검색조건
	 * @return List 업무사용자 목록정보
	 */
	public List<?> selectList(ComDefaultVO searchVO,String sql_id){		
		return selectList(sql_id, searchVO);
	}
	
	/**
	 * 목록
	 * @param userSearchVO 검색조건
	 * @return List 업무사용자 목록정보
	 */	
	public List<?> selectList(HashMap<String,Object> searchVO,String sql_id){
		return selectList(sql_id, searchVO);
	}

	/**
	 * 개수를 조회한다.
	 * @param searchVO 검색조건
	 * @return int 게시판 총갯수
	 */
	public int selectListTotCnt(ComDefaultVO searchVO,String sql_id) {
		return (Integer)selectOne(sql_id, searchVO);
	}
	
	/**
	 * 개수를 조회한다.
	 * @param searchVO 검색조건
	 * @return int 게시판 총갯수
	 */
	public int selectListTotCnt(HashMap<String, Object> searchVO,String sql_id) {
		return (Integer)selectByPk(sql_id, searchVO);
	}
	
	/**
	 * 정보를 저장한다.
	 * @param searchVO 저장 데이터
	 * @return String 등록결과
	 */
	public String insert(ComDefaultVO searchVO,String sql_id){
		int tmp = (int)insert(sql_id, searchVO);
		return String.valueOf(tmp);
	}
	
	/**
	 * 정보를 저장한다.
	 * @param searchVO 저장 데이터
	 * @return String 등록결과
	 */
	public String insert(HashMap<String,Object> searchVO,String sql_id){
		int tmp = (int)insert(sql_id, searchVO);
		return String.valueOf(tmp);
	}
	
	/**
	 * 정보를 저장한다.
	 * @param searchVO 저장 데이터
	 * @return String 등록결과
	 
	public String insert(HashMap<String,Object> searchVO,String sql_id){
		return (String)insert(sql_id, searchVO);
	}*/

	/**
	 * 상세정보를 불러온다.
	 * @param searchVO 저장 데이터
	 * @return String 등록결과
	 */
	public ComDefaultVO selectView(ComDefaultVO searchVO,String sql_id){
		return (ComDefaultVO) selectOne(sql_id, searchVO);
	}
	
	/**
	 * 상세정보를 불러온다.
	 * @param searchVO 저장 데이터
	 * @return String 등록결과
	 */
	public HashMap<String,Object> selectView(HashMap<String,Object> searchVO,String sql_id){
		return (HashMap<String,Object>) selectOne(sql_id, searchVO);
	}

	/**
	 * 수정한다.
	 * @param searchVO 저장 데이터
	 * @return String 등록결과
	 */
	public int update(ComDefaultVO searchVO,String sql_id){
		
		int result = update(sql_id, searchVO);
				
		return result;
	}

	/**
	 * 삭제한다.
	 * @param searchVO 저장 데이터
	 * @return String 등록결과
	 */
	public int delete(ComDefaultVO searchVO,String sql_id){
		return delete(sql_id, searchVO);
	}
	
	/**
	 * 삭제한다.
	 * @param searchVO 저장 데이터
	 * @return String 등록결과
	 */
	public int delete(HashMap<String,Object> searchVO,String sql_id){
		return delete(sql_id, searchVO);
	}
	
}
