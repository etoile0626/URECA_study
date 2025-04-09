package kr.co.ureca.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/reply")
	public String replyTest() {
		return new String("<h1>GateWay - Reply1 Server - replyTest</h1>");
	} // replyTest

	@GetMapping("/")
	public String home() {

		return "index";
	} // home

} // class
