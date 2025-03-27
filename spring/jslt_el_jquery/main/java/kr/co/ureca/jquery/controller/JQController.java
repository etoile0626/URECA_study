package kr.co.ureca.jquery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JQController {
	
	@GetMapping("/jq6")
	public String jq6Selector() {
		return "jq6selector";
	}
	
	@GetMapping("/jq5")
	public String jq5Selector() {
		return "jq5selector";
	}
	
	@GetMapping("/jq4")
	public String jq4Selector() {
		return "jq4selector";
	}
	
	@GetMapping("/jq3")
	public String jq3Selector() {
		return "jq3selector";
	}
	
	@GetMapping("/jq2")
	public String jq2Selector() {
		return "jq2selector";
	}
	
	@GetMapping("/jq1")
	public String jq1Start() {
		return "jq1start";
	}
}
