package kr.co.ureca.blog.config;

import kr.co.ureca.blog.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration                       이건 스프링 시큐리티 설정 파일
//@EnableWebSecurity                   OAuth와 JWT를 같이 사용하기위해 주석하고 새로 설정파일 만듦
@RequiredArgsConstructor
public class webSecurityConfig {
    
    private final UserDetailService userService;
    
    //@Bean   //이런 예외 적용도 다 빈으로 등록해야함
    public WebSecurityCustomizer configure() {      //스프링 시큐리티 기능 비활성화
        return (web) -> web.ignoring()
                //static 폴더 아래에서는 시큐리티 안 쓰게 해주세요
                .requestMatchers(new AntPathRequestMatcher("/static/**"));        
    }

    //특정 http 요청에 대한 웹 기반 보안 구성
    //@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests( auth
                        -> auth.requestMatchers(
                                new AntPathRequestMatcher("/login"),
                                new AntPathRequestMatcher("/signup"),
                                new AntPathRequestMatcher("/user")
                        ).permitAll()
                        .anyRequest().authenticated() ) // authorizeRequests
                //폼 기반 로그인 설정
                .formLogin( formLogin
                        -> formLogin.loginPage("/login")
                        .defaultSuccessUrl("/articles") ) // formLogin
                //로그아웃 설정
                .logout( logout
                        -> logout.logoutSuccessUrl("/login")
                        .invalidateHttpSession(true) ) // logout
                .csrf(AbstractHttpConfigurer::disable)  //csrf 비활성화
                .build();
    } // filterChain

    //인증 관리자 관련 설정
    //@Bean
    public AuthenticationManager authenticationManager(HttpSecurity http
                                            , BCryptPasswordEncoder bCryptPasswordEncoder
                                            , UserDetailService userDetailService)throws Exception{

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);

        return new ProviderManager(authProvider);
    }
    
    //패스워드 인코더로 사용하기 위한 빈
    //@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
