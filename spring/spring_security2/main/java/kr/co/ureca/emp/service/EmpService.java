package kr.co.ureca.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.emp.repository.EmpRepository;
import kr.co.ureca.entity.Emp;

@Service
public class EmpService {

	@Autowired
	private EmpRepository repository;
	
	public List<EmpDTO> empFindAll() {
		List<Emp> empList = repository.findAll();
		
		List<EmpDTO> list = new ArrayList<>();
		for(Emp emp : empList) {
			EmpDTO dto = new EmpDTO(emp.getId()
					, emp.getEmpno()
					, emp.getEname()
					, emp.getJob()
					, emp.getMgr()
					, emp.getHiredate()
					, emp.getSal()
					, emp.getComm()
					, emp.getDeptno());
			
			list.add(dto);
		}
		
		return list;
	}

	public EmpDTO empFindById(Long id) {
		Optional<Emp> opEmp = repository.findById(id);
		
		Emp emp = opEmp.get();
		
		EmpDTO dto = new EmpDTO(emp.getId()
				, emp.getEmpno()
				, emp.getEname()
				, emp.getJob()
				, emp.getMgr()
				, emp.getHiredate()
				, emp.getSal()
				, emp.getComm()
				, emp.getDeptno());
		
		return dto;
	}

	public EmpDTO empInsert(EmpDTO dto) {
		
		Emp emp = new Emp();
		emp.setEmpno(dto.getEmpno());		emp.setEname(dto.getEname());
		emp.setJob(dto.getJob());			emp.setMgr(dto.getMgr());
		emp.setHiredate(dto.getHiredate());	emp.setSal(dto.getSal());
		emp.setComm(dto.getComm());			emp.setDeptno(dto.getDeptno());
		
		Emp savedEmp = repository.save(emp);

		dto.setId(savedEmp.getId()); 
		
		return dto;
	}
}
