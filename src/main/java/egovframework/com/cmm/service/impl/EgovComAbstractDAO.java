package egovframework.com.cmm.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * EgovComAbstractDAO.java 클래스
 * 
 * @author 서준식
 * @since 2011. 9. 23.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2011. 9. 23.   서준식        최초 생성
 * </pre>
 */
public abstract class EgovComAbstractDAO extends EgovAbstractMapper{
	
	/*
	@Resource(name="egov.sqlMapClient")
	public void setSuperSqlMapClient(SqlMapClient sqlMapClient) {
        super.setSuperSqlMapClient(sqlMapClient);
    }
    */
	
	
	/**
     * Annotation 형식으로 sqlSession(SqlSessionFactoryBean)을 받아와 
     * 이를 super(SqlSessionDaoSupport)의 setSqlSessionFactory 메서드를 호출하여 설정해 준다.
     * <p>
     * SqlSessionTemplate이 지정된 경우된 경우 이 SqlSessionFactory가 무시된다. (Batch 처리를 위해서는 SqlSessionTemplate가 필요)
     * 
     * 
     * @param sqlSession SqlSessionFactory로 MyBatis와의 연계를 위한 기본 클래스
     */
    @Resource(name = "sqlSession")
    public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
    	super.setSqlSessionFactory(sqlSession);
    }
	

}
