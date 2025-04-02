package kr.co.ureca.s4interceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class InterceptorTestController {

	public static final Logger logger = LoggerFactory.getLogger(InterceptorTestController.class);

	@GetMapping("/itcp1")
	public String interceptor1(Model model, HttpServletRequest req, HttpServletResponse res) {
		logger.info(">>> interceptor1 <<<");

		model.addAttribute("className", "InterceptorTestController-interceptor1");
		req.setAttribute("author", "hongGilDong");
		Cookie coo = new Cookie("time", "14:30");
		res.addCookie(coo);

		return "interceptor1";
	} // interceptor1

	@GetMapping("/itcp2")
	public String interceptor2(Model model) {
		logger.info(">>> interceptor2 <<<");

		model.addAttribute("className", "InterceptorTestController-interceptor2");

		return "interceptor2";
	} // interceptor2

} // class
