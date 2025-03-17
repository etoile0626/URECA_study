package kr.co.ureca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.dto.EmpSearchDTO;
import kr.co.ureca.repository.EmpTestRepository;

@Service
public class EmpTestService { 		//requestmapping을 제외하고 컨트롤러에 있던 메소드가 와야함
	
	@Autowired
	private EmpTestRepository empTestRepository;

	public List<EmpDTO> empSelectAll() {
		List<EmpDTO> list = empTestRepository.empSelectAll();
		return list;
	}

	public EmpDTO empSelectByEname(String ename) {
		EmpDTO dto = empTestRepository.empSelectByEname(ename);
		return dto;
	}
	
	public List<EmpDTO> empSelectByLike(String ename) {
		List<EmpDTO> list = empTestRepository.empSelectByLike(ename);
		return list;
	}

	public int empInsert(EmpDTO dto) {
		int successCnt = empTestRepository.empInsert(dto);
		return successCnt;
	}
	
	public int empInsertList(ArrayList<EmpDTO> insList) {
		int successCnt = empTestRepository.empInsertList(insList);
		return successCnt;
	}
	
	public int empUpdate(EmpDTO dto) {
		int successCnt = empTestRepository.empUpdate(dto);
		return successCnt;
	}
	
	//delete는 패스


	public List<EmpDTO> selectIn(ArrayList<String> enameList) {
		List<EmpDTO> list = empTestRepository.selectIn(enameList);
		return list;
	}

	public List<EmpDTO> selctSearch(EmpSearchDTO dto1) {
		List<EmpDTO> list = empTestRepository.selectSearch(dto1);
		return list;
	}

	
}
