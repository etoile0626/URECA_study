package kr.co.ureca.blog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
//자바 클래스에 프로퍼티 값 가져와서 사용하는 어노테이션
@ConfigurationProperties("jwt") //application.yml에 있는 jwt부분을 읽어서 가져오게함
public class JwtProperties {

    private String issuer;

    private String secretKey;
}
