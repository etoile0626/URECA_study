package kr.co.ureca.jstl.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kr.co.ureca.dto.BoardDTO;

@Controller
public class JSTLController {
	
	@GetMapping("/jstl9")
	public String jstl9Function() {
		
		return "jstl9function";
	}
	
	@GetMapping("/jstl8")
	public String jstl8Format() {
		
		return "jstl8format";
	}
	
	@GetMapping("/jstl7")
	public String jstl7Redirect() {
		
		return "jstl7redirect";
	}
	
	@GetMapping("/jstl6")
	public String jstl6Import() {
		
		return "jstl6import";
	}
	
	@GetMapping("/jstl5")
	public String jstl5Url2(BoardDTO dto) {
		//dto의 변수명과 parameter로 받은 애의 변수명이 같으면 자동 매핑해주는 어노테이션 (생략가능)-@RequestBody
		System.out.println(dto); //parameter로 값 전달 받은걸 콘솔에서도 확인가능
		return "jstl5url2";
	}
	
	@GetMapping("/jstl4")
	public String jstl4Url() {
		
		return "jstl4url";
	}
	
	@GetMapping("/jstl3")
	public String jstl3Loop(Model model, ArrayList<String> list) {
		
		list.add("hi"); list.add("hello"); 
		list.add("how are"); list.add("you fine"); 
		list.add("thanks you");
		
		model.addAttribute("myList", list);
		
		ArrayList<BoardDTO> board_list = new ArrayList<>();
		BoardDTO dto1 = new BoardDTO("123", "노인과바다", "헤밍웨이", "SAD...", "1945-08-15");
		BoardDTO dto2 = new BoardDTO("456", "해리포터", "롤링", "happy", "2000-08-15");
		BoardDTO dto3 = new BoardDTO("789", "신조협려", "김용", "love", "1960-08-15");
		board_list.add(dto1); board_list.add(dto2); board_list.add(dto3); 
		
		model.addAttribute("board_list", board_list);
		
		return "jstl3loop";
	}
	
	@GetMapping("/jstl2")
	public String jstl2Branch() {
		
		return "jstl2branch";
	}
	
	@GetMapping("/jstl1")
	public String jstl1Basic() {
		
		return "jstl1basic";
	}
}
