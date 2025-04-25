package kr.co.ureca.s12ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dong")
public class DongController {

	@GetMapping("/code")
	public String code() {
		return "dong/code";
	} // code

	@GetMapping("/search")
	public String search() {
		return "dong/search";
	} // search

} // class
