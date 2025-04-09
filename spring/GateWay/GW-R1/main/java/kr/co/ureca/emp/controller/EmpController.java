package kr.co.ureca.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.emp.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/list")
	public String empFindAll(Model model){
		
		List<EmpDTO> list = service.empFindAll();
		
		model.addAttribute("emp_list", list);
		
		return "emp/list";		//jsp 화면 이름
	}
	
	@GetMapping("/detail/{id}")
	public String empFindById(Model model, @PathVariable("id") Long id){
		
		EmpDTO dto = service.empFindById(id);
		
		model.addAttribute("emp_detail", dto);
		
		return "emp/detail";		//jsp 화면 이름
	}
	
	@GetMapping("/insform")
	public String empInsertFrom() {
		return "emp/insert";
	}
	
	@PostMapping("/insert")
	public String empInsert(Model model, EmpDTO dto) {
		
		EmpDTO savedDto = service.empInsert(dto);
		if(savedDto.getId() != null && savedDto.getId() > 0L) {
			return "redirect:http://localhost:8080/api1/emp/list";
		} else {
			model.addAttribute("message", "입력 실패");
			return "error";
		}
	}
}
