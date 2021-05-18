package egovframework.com.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.MainDAO;
import egovframework.com.test.service.TestVO;

@Repository("testDAO") //testDAO라고 이름을 정함
public class TestDAO extends MainDAO {
	public List<?> selectList(TestVO testVO, String sql_id){
		return selectList(sql_id, testVO);
	}
	
	public TestVO selectView(TestVO testVO, String sql_id) {
		return (TestVO)selectOne(sql_id, testVO);
	}
	
	public String insert(TestVO testVO, String sql_id) {
		int tmp = (int)insert(sql_id, testVO);
		return String.valueOf(tmp);
	}
	
	public void update(TestVO testVO, String sql_id) {
		update(sql_id, testVO);
	}
	
	public void delete(TestVO testVO, String sql_id) {
		delete(sql_id, testVO);
	}
}
