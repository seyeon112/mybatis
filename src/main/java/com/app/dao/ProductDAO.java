package com.app.dao;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.app.mybatis.config.MyBatisConfig;
import com.app.vo.ProductVO;

public class ProductDAO {
	public SqlSession sqlSession;
	
	
	//객체화(기본생성자 호출)이 될 떄 마다
	//SqlSessions를 통해 만들어진 SqlSessions을 기본 생성자에 만들어 놓고 호출될 때 마다 담게한다. 
	//OpenSession()이 SqlSession을 return 해주는 메서드이다. 
	//OpenSession(autoCommit) : JSP에서는 자동으로 이루어지지만 spring 에서는 트렌젝션이 관리한다.
	
	public ProductDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		
	}
	
	//상품추가
	public void insert(ProductVO productVO) {
		sqlSession.insert("product.insert", productVO);
	}
	
	//상품 전체 조회
	public List<ProductVO> selectAll() {
		sqlSession.selectList("product.selectALL");
	}
	
	//상품 조회
	public Optional<ProductVO> select(Long id) {
		return Optional.ofNullable(sqlSession.selectOne("product.select", id));
	}
	
	//상품 수정
	
	//상품 삭제 
	
	
	
	
}
