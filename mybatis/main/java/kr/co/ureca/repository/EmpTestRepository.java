package kr.co.ureca.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.dto.EmpSearchDTO;
import kr.co.ureca.mapper.MybatisInterface1;
import kr.co.ureca.mapper.MybatisInterface2;

@Repository
public class EmpTestRepository { 		//requestmapping을 제외하고 컨트롤러에 있던 메소드가 와야함
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private MybatisInterface1 interface1;
	
	@Autowired
	private MybatisInterface2 interface2;
	
	public List<EmpDTO> empSelectAll() {
		//0.xml을 이용한 Mapper
		List<EmpDTO> list = sqlSession.selectList("EmpTestMapper.empSelectAll"); //mapper 불러오기
		//1. interface를 사용한 Mapper (권장하진 않음)
		//List<EmpDTO> list = interface1.getAllEmp1();
		return list;
	}

	public EmpDTO empSelectByEname(String ename) {
		//0.xml을 이용한 Mapper
		EmpDTO dto = sqlSession.selectOne("EmpTestMapper.empSelectByEname", ename);
		
		//1.인터페이스 사용한 Mapper
		//EmpDTO dto = interface1.getEmpByEname1(ename);
		
		//2.인터페이스와 xml을 결합한 Mapper
		//EmpDTO dto = interface1.getEmpByEname2(ename);
		return dto;
	}

	public int empInsert(EmpDTO dto) {
		//0. xml을 사용한 Mapper
		int successCnt = sqlSession.insert("EmpTestMapper.empInsert", dto);
		
		//1. 인터페이스 이용한 Mapper
		//int successCnt = interface1.insEmp1(dto);
		
		System.out.println("selectkey empno-repository : "+dto.getEmpno());
		return successCnt;
	}
	
	public int empInsertList(ArrayList<EmpDTO> insList) {
		int successCnt = sqlSession.insert("EmpTestMapper.empInsertList", insList);
		return successCnt;
	}

	public int empUpdate(EmpDTO dto) {
		int successCnt = sqlSession.update("EmpTestMapper.empUpdate", dto);
		return successCnt;
	}

	//delete는 패스

	public List<EmpDTO> selectIn(ArrayList<String> enameList) {
		List<EmpDTO> list = sqlSession.selectList("EmpTestMapper.selectIn", enameList);
		return list;
	}

	public List<EmpDTO> selectSearch(EmpSearchDTO dto1) {
		List<EmpDTO> list = sqlSession.selectList("EmpTestMapper.selectSearch", dto1);
		return list;
	}
	
}
