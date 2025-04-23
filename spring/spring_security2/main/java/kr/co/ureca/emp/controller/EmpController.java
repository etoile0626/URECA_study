package kr.co.ureca.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.emp.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService service;
	
	@PreAuthorize("hasRole('ADMIN')")	//authorize가 있어야한다는 의미
	@GetMapping("/list")
	public List<EmpDTO> empFindAll() {
		List<EmpDTO> list = service.empFindAll();
		
		return list;
	}
	
	@GetMapping("/detail/{id}")
	public EmpDTO empFindById(@PathVariable("id") Long id) {
		
		EmpDTO dto = service.empFindById(id);
		
		return dto;
	}
	
	@PostMapping("/insert")
	public String empInsert(@RequestBody EmpDTO dto){
		
		EmpDTO savedDTO = service.empInsert(dto);
		
		if(savedDTO.getId() != null && savedDTO.getId() > 0L) {
			return "사원 입력 성공";
		} else {
			return "error_message : 사원 입력을 실패하였습니다.<br>잠시 후 다시 시도해 보시기 바랍니다.";
		}

	}
}
