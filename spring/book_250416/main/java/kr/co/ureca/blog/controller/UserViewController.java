package kr.co.ureca.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/login")
    public String login() {
//        return "login";
        return "oauthLogin";
    } // login

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    } // signup

} // class
