package kr.co.ureca.el.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.co.ureca.dto.BoardDTO;

@Controller
public class EL1Basic {
	
	@GetMapping("/el3")	
	public String collections(Model model, ArrayList<String> list, HashMap<String, String> map) {
		map.put("반장", "고길동"); map.put("부반장", "둘리"); map.put("부장", "홍길동");
		model.addAttribute("myMap", map);
		list.add("hi"); list.add("hello"); list.add("how are");
		model.addAttribute("myList", list);
		return "el3collections";
	}

	@GetMapping("/el2") //model이 보통 데이터를 끌고 오는 역..할??기억 잘 안남
	public String data(Model model, HttpServletRequest request, HttpSession session) {
		
		request.setAttribute("msgFromReqeust", "이것은 리퀘스트를 통한 데이터 전달입니다.");
		
		session.setAttribute("msgFromRSession", "이것은 세션을 통한 데이터 전달입니다.");
		
		BoardDTO dto = new BoardDTO("123", "노인과바다", "헤밍웨이", "SAD...", "1945-08-15");
		
		model.addAttribute("board_dto",dto);
		
		return "el2data";
	}
	
	//@RequestMapping(value="el1", method = RequestMethod.GET)
	@GetMapping("/el1")	//위에랑 똑같은 표현
	public String basic() {
		
		return "el1basic";		//화면 이름 리턴(jsp 파일 이름) /WEB-INF/views/el1basic.jsp가 될 예정
	}
}
