package kr.co.ureca.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	} // index
	
	//emp 입력 창
	@RequestMapping(value = "/emp/insform", method = RequestMethod.GET)
	public String empInsertFrom() {
		return "emp_insform";
	}

} // class
