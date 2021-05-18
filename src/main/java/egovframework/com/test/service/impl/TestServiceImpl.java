package egovframework.com.test.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import egovframework.com.test.service.TestService;
import egovframework.com.test.service.TestVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


@Service("testService")
public class TestServiceImpl extends EgovAbstractServiceImpl implements TestService {
	
	@Resource(name = "testDAO")
	private TestDAO testDAO;
	
	public List<?> selectList(TestVO testVO, HttpServletRequest req, HttpServletResponse res){
		return testDAO.selectList(testVO, "testDAO.selectTestList");
	}
	
	public TestVO selectView(TestVO testVO, HttpServletRequest req, HttpServletResponse res){
		return testDAO.selectView(testVO, "testDAO.selectTestView");
	}
	
	public String insert(TestVO testVO, HttpServletRequest req, HttpServletResponse res){
		return testDAO.insert(testVO, "testDAO.insertTest");
	}
	
	public void update(TestVO testVO, HttpServletRequest req, HttpServletResponse res){
		testDAO.update(testVO, "testDAO.updateTest");
	}
	
	public void delete(TestVO testVO, HttpServletRequest req, HttpServletResponse res){
		testDAO.delete(testVO, "testDAO.deleteTest");
	}
}