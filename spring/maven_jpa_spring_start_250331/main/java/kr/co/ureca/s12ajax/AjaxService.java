package kr.co.ureca.s12ajax;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.dto.util.EmpToDtO;
import kr.co.ureca.entity.Emp;
import kr.co.ureca.s5getpost.repository.EmpRepository;

@Service
public class AjaxService {
	
	@Autowired
	private EmpRepository empRepository;
	
	public int empnoDuplicateCheck(Integer empno) {
		
		int duplicateFlag = 0;
		Emp emp = empRepository.findByEmpno(empno);
		
		if(emp != null) {//Duplicate
			duplicateFlag++;
		} else {		//not duplicate
			//뭐 할게 없음
		}
		return duplicateFlag;
	}

	public List<EmpDTO> empFindAll() {
		List<Emp> empList = empRepository.findAll();
		List<EmpDTO> list = new ArrayList<>();
		for(Emp emp : empList) {
			list.add(EmpToDtO.empToDTO(emp));
		}
		return list;
	}

	public int empInsert(EmpDTO dto) {
		int insertFlag = 0;
		Emp emp = EmpToDtO.DTOToEmp(dto); 
		Emp savedEmp = empRepository.save(emp);
		
		if(savedEmp != null && savedEmp.getId() != null && savedEmp.getId() > 0) {//Duplicate
			insertFlag++;
		} else {		
			//입력 실패한게 끝이라 뭐 할게 없음
		}
		return insertFlag;
	}
}
