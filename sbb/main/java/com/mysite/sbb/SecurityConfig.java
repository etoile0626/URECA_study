package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration			//스프링 환경 설정 파일임을 명시
@EnableWebSecurity		//모든 url 요청이 스프링 시큐리티의 제어를 받을 것임을 명시
@EnableMethodSecurity(prePostEnabled = true) //@preAuthorize 애너테이션 동작을 위한 설정
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http
			.authorizeHttpRequests( (authiruzeHttpRequests) -> authiruzeHttpRequests
																.requestMatchers(new AntPathRequestMatcher("/**"))
																.permitAll())
			.csrf( (csrf) -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
			.headers((headers) -> headers
	                .addHeaderWriter(new XFrameOptionsHeaderWriter(
	                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
			.formLogin( (formLogin) -> formLogin.loginPage("/user/login")	//로그인 url
												.defaultSuccessUrl("/"))	//성공 시 갈 주소
			.logout( (logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")) //로그아웃 url
									  .logoutSuccessUrl("/")
									  .invalidateHttpSession(true))
			;
		return http.build();
	}
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean					//인증을 처리하는 애      //인증 시 usersecuritydetails와 passwordencoder를 내부적으로 사용하여 인증과 권한 부여 프로세스를 처리 
	AuthenticationManager authenticationManager(AuthenticationConfiguration 
												authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
}
