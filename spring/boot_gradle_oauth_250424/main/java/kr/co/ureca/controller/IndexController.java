package kr.co.ureca.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class IndexController {

    private final Environment environment;
    
    public IndexController(Environment environment){
        this.environment = environment;
    }

    //yml 파일에 담긴 client-id 값 가져오기 2번 방법
    //@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String kakaoIDValue;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/mylogout")
    public ResponseEntity<Object> myLogout() throws URISyntaxException {
        //yml 파일에 담긴 client-id 값 가져오기. 1번 방법
        String kakaoID
                = this.environment.getProperty("spring.security.oauth2.client.registration.kakao.client-id");

        //로그아웃 쿼리 등록 중
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("https://kauth.kakao.com/oauth/logout");
        strBuild.append("?client_id=" + kakaoID);
        strBuild.append("&logout_redirect_uri=" + "http://localhost:8080/logout");

        String kakaoLogoutURL = strBuild.toString();

        URI redirectUri = new URI(kakaoLogoutURL);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUri);

        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
}
