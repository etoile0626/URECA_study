package kr.co.ureca.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.emp.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService service;
	
	@GetMapping("/list")
	public String empFindAll(Model model) {
		List<EmpDTO> list = service.empFindAll();
		
		model.addAttribute("emp_list", list);
		
		return "emp/list";
	}
	
	@GetMapping("/detail/{id}")
	public String empFindById(Model model, @PathVariable("id") Long id) {
		
		EmpDTO dto = service.empFindById(id);
		
		model.addAttribute("emp_detail", dto);
		
		return "emp/detail";
	}
	
	@GetMapping("/insform")
	public String empInsertFrom() {
		return "emp/insert";
	}
	
	@PostMapping("/insert")
	public String empInsert(Model model, @RequestBody EmpDTO dto){
		
		EmpDTO savedDTO = service.empInsert(dto);
		
		if(savedDTO.getId() != null && savedDTO.getId() > 0L) {
			return "redirect:/emp/list";
		} else {
			model.addAttribute("error_message", "Fail To Insert.");
			return "error";
		}

	}
}
