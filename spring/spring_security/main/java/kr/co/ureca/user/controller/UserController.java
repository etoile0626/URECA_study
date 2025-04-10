package kr.co.ureca.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.ureca.dto.UserDTO;
import kr.co.ureca.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/join/form")
	public String joinForm() {
		return "user/join";
	}
	
	@PostMapping("/join/ins")
	public String join(Model model, UserDTO dto) {
		UserDTO savedDTO = service.join(dto);
		if(savedDTO.getId() != null && savedDTO.getId() > 0L) {
			return "redirect:/user/login/form";
		} else {
			model.addAttribute("error_message", "회원 가입 실패하였습니다. 다시 시도해주세요.");
			return "error";
		}
	}
	
	@GetMapping("/login/form")
	public String loginForm() {
		return "user/login";
	}
	
	/*spring security로 대체됨
	@GetMapping("/login/ins")
	public String login(UserDTO dto, Model model, HttpSession session) {
		UserDTO selectedDTO = service.login(dto);
		if(selectedDTO.getId() != null && selectedDTO.getId() > 0L) {
			session.setAttribute("login_user", selectedDTO);
			return "redirect:/";
		} else {
			model.addAttribute("error_message", "로그인 실패하였습니다. 다시 시도해주세요.");
			return "error";
		}
	}
	*/
	
	/* spring security로 대체됨
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}*/
}
