package kr.co.ureca.s5annotation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.dto.util.EmpToDTO;
import kr.co.ureca.entity.Emp;
import kr.co.ureca.s5annotation.repository.EmpRepository;

@Service
public class RestTestService {
	
	@Autowired
	private EmpRepository repository;
	
	public EmpDTO findById(Long id) {
		Optional<Emp> opEmp = repository.findById(id);
		Emp emp = opEmp.get();
		EmpDTO dto = EmpToDTO.empToDTO(emp);
		return dto;
	}

	public EmpDTO empInsert(EmpDTO dto) {
		//EmpDTO Emp 객체에 담기 
		Emp emp = EmpToDTO.dtoToEmp(dto);
		
		//담은 객체 저장
		Emp savedEmp = repository.save(emp);
		
		//dto에 id만 담아서 리턴
		dto.setId(emp.getId());
		return dto;
	}

	public EmpDTO empUpdate(EmpDTO dto) {
		Emp emp = repository.findByEmpno(dto.getEmpno()); //논리적으로 empno가 유니크하다고 가정
		Emp emp2 = EmpToDTO.dtoToEmp(dto);
		emp2.setId(emp.getId());
		repository.save(emp2);
		dto.setId(emp.getId());
		return dto;
	}

	public String empDelete(EmpDTO dto) {
		Emp emp = repository.findByEmpno(dto.getEmpno());
		repository.delete(emp);
		return "delete success";
	}
}
