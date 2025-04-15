package com.mysite.sbb.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {	//userCreateForm을 넣지 않으면 다시 이 화면으로 올때 입력값들이 날라감 
        return "signup_form";
    }
	
	@PostMapping("/signup")		//화면에서 넘어온 정보를 userCreateForm으로 받음
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", 
                    "2개의 패스워드가 일치하지 않습니다."); //(필드(에러가 난 부분), 에러코드, 에러 메세지)
            return "signup_form";
        }
        
        try {
	        userService.create(userCreateForm.getUsername(), 
	                		userCreateForm.getEmail(), userCreateForm.getPassword1());
        } catch(DataIntegrityViolationException e) {			//중복 사용자 등록시
        	e.printStackTrace();
        	bindingResult.reject("signupFailed", "이미 등록된 사용자 입니다.");
        	return "signup_form";
        } catch(Exception e) {									//그 외 기타 에러 시
        	e.printStackTrace();
        	bindingResult.reject("signupFailed", e.getMessage());
        	return "signup_form";
        }
        
        return "redirect:/";
    }

}
