package kr.co.ureca.s12ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ureca.dto.EmpDTO;

@RestController
@RequestMapping("/ajax-api")
public class AjaxApiController {
	
	@Autowired
	private AjaxService ajaxService;
	
	@GetMapping("/ajax1")
	public String ajax1(@RequestParam String name, @RequestParam String email) {
		return name + " 님의 이메일은 " + email + "입니다.";
	}
	
	@PostMapping("/ajax1post")
	public String ajax1post(@RequestParam String name, @RequestParam String email) {
		return name + " 님의 이메일은 " + email + "입니다.";
	}
	
	@PostMapping("/ajax2")
	public int ajax2(@RequestParam Integer empno) {
		return ajaxService.empnoDuplicateCheck(empno);
	}
	
	@GetMapping("/ajax3")
	public List<EmpDTO> ajax3() {
		return ajaxService.empFindAll();
	}
	
	@PostMapping("/ajax4")
	public int ajax4(EmpDTO dto) {
		System.out.println("Ajax4 - insert");
		return ajaxService.empInsert(dto);
	}
}
