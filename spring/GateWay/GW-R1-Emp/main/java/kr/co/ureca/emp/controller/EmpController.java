package kr.co.ureca.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/list")
	public ResponseEntity<List<EmpDTO>> empFindAll() {
		List<EmpDTO> list = service.empFindAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<EmpDTO> empFindById(@PathVariable("id") Long id) {
		
		EmpDTO dto = service.empFindById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<EmpDTO> empInsert( @RequestBody EmpDTO dto){
		
		EmpDTO savedDTO = service.empInsert(dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
}
