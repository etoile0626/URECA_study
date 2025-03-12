package kr.co.ureca.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ureca.dto.EmpDTO;

@Repository
public class EmpTestRepository { 		//requestmapping을 제외하고 컨트롤러에 있던 메소드가 와야함
	
	@Autowired
	private SqlSession sqlSession;

	public List<EmpDTO> empSelectAll() {
		List<EmpDTO> list = sqlSession.selectList("EmpTestMapper.empSelectAll"); //mapper 불러오기
		return list;
	}

	public EmpDTO empSelectByEname(String ename) {
		EmpDTO dto = sqlSession.selectOne("EmpTestMapper.empSelectByEname", ename);
		return dto;
	}

	public void empInsert() {
		
	}

	public void empUpdate() {
		
	}

	public void empDelete() {
		
	}
}
