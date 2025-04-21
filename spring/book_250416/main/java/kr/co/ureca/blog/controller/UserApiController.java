package kr.co.ureca.blog.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.ureca.blog.dto.AddUserRequest;
import kr.co.ureca.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {
    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request){
        userService.save(request);      //회원가입 메서드 호출
        return "redirect:/login";       //회원가입 완료 후 로그인 페이지 이동
    }

    public String logout(HttpServletRequest request
            , HttpServletResponse response){
        new SecurityContextLogoutHandler()
                .logout(request
                        , response
                , SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}
