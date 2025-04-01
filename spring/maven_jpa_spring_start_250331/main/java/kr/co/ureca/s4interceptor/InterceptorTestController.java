package kr.co.ureca.s4interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class InterceptorTestController {

	@GetMapping("/itcp1")
	public String interceptor1(Model model, HttpServletRequest req, HttpServletResponse res ) {
		model.addAttribute("className", "InterceptorTestComtroller-interceptor1");
		req.setAttribute("Author", "gilDong");
		Cookie coo = new Cookie("time", "14:30");
		res.addCookie(coo);
		
		return "interceptor1";
	}
	
	@GetMapping("/itcp2")
	public String interceptor2(Model model) {
		model.addAttribute("className", "InterceptorTestComtroller-interceptor2");
		return "interceptor2";
	}
	
}
