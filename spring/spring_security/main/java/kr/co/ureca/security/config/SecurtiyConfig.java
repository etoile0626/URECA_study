package kr.co.ureca.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity//(debug = true)	//security filter chain 등록을 위해 선언, debug-security 관련 콘솔 출력을 위한 옵션
public class SecurtiyConfig {
	
	@Bean
	public BCryptPasswordEncoder encodePassword() {	//password 인코더해주는 객체?
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		//간단한 security Filter 하나
		httpSecurity.csrf(CsrfConfigurer::disable)		//CSRF 방지 기능 꺼짐 상태
					.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll()
					.formLogin(formLogin -> {
						formLogin.loginPage("/user/login/form")
								 .loginProcessingUrl("/user/login/ins")
								 .defaultSuccessfil("/");
					})
					.logout(logout -> logout		//url을 맞춰주는 놈?	
											.logoutReqeustMatcher(new AntPathRequestMatcher("/user/logout"))
											.logoutSuccessUrl("/")
											.invalidateHttpSession(true)
							);
		
		return httpSecurity.build();
	}
	
}
