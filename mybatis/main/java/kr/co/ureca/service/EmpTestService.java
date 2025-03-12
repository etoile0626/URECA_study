package kr.co.ureca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.EmpDTO;
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

	public void empInsert() {
		
	}

	public void empUpdate() {
		
	}

	public void empDelete() {
		
	}
}
