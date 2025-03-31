package kr.co.ureca.jquery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JQController {
	
	@GetMapping("/jq17")
	public String jq17Traverse() {
		return "jq17traverse";
	}
	
	@GetMapping("/jq16")
	public String jq16Parents() {
		return "jq16parents";
	}
	
	@GetMapping("/jq15")
	public String jq15AddClass() {
		return "jq15addclass";
	}
	
	@GetMapping("/jq14")
	public String jq14Search() {
		return "jq14search";
	}
	
	@GetMapping("/jq13")
	public String jq13NthChild() {
		return "jq13nthchild";
	}
	
	@GetMapping("/jq12")
	public String jq12TableHover() {
		return "jq12tablehover";
	}
	
	@GetMapping("/jq11")
	public String jq11SlideUpDown() {
		return "jq11slideupdown";
	}
	
	@GetMapping("/jq10")
	public String jq10FadeInOut() {
		return "jq10fadeinout";
	}
	
	@GetMapping("/jq9")
	public String jq9HideShow() {
		return "jq9hideshow";
	}
	
	@GetMapping("/jq8")
	public String jq8Selector() {
		return "jq8selector";
	}
	
	@GetMapping("/jq7")
	public String jq7Selector() {
		return "jq7selector";
	}
	
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
