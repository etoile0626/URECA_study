package kr.co.ureca.book1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test")
    public Member Test(){
        return new Member(4L, "홍길동");
    }
}
