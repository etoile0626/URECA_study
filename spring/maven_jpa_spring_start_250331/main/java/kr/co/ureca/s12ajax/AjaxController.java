package kr.co.ureca.s12ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	@GetMapping("/ajxa1")
	public String ajax1() {
		return "ajax/ajax1";
	}
	
	@GetMapping("/ajxa2")
	public String ajax2() {
		return "ajax/ajax2";
	}
	
	@GetMapping("/ajxa3")
	public String ajax3() {
		return "ajax/ajax3";
	}
	
	@GetMapping("/ajxa4")
	public String ajax4() {
		return "ajax/ajax4";
	}
}
