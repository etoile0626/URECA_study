package kr.co.ureca.s5getpost.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.dto.util.EmpToDTO;
import kr.co.ureca.entity.Emp;
import kr.co.ureca.s5getpost.repository.EmpRepository;

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
		Emp emp = EmpToDTO.dtoToEmp(dto);
		Emp savedEmp = repository.save(emp);
		dto.setId( savedEmp.getId() );
		return dto;
	} // empInsert

	public EmpDTO empUpdate(EmpDTO dto) {
		Emp emp = repository.findByEmpno( dto.getEmpno() );

		Emp emp2 = EmpToDTO.dtoToEmp(dto);
		emp2.setId( emp.getId() );
		repository.save(emp2);

		dto.setId( emp.getId() );
		return dto;
	} // empUpdate

	public String empDelete(EmpDTO dto) {
		Emp emp = repository.findByEmpno( dto.getEmpno() );
		repository.delete(emp);

		return "Delete Success";
	} // empDelete

} // class
