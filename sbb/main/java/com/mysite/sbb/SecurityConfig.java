package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} // passwordEncoder

	@Bean
	public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
		http
			.authorizeHttpRequests( (authorizeHttpRequests)
										-> authorizeHttpRequests
											.requestMatchers("/**").permitAll() ) // authorizeHttpRequests
			.csrf( (csrf)
						-> csrf.ignoringRequestMatchers( new AntPathRequestMatcher("/h2-console/**") ) ) // csrf
			.headers( (headers)
						-> headers.addHeaderWriter(
								new XFrameOptionsHeaderWriter(
										XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN ) ) ) // headers
			.formLogin( (formLogin) -> formLogin.loginPage("/user/login")
												.defaultSuccessUrl("/") ) // formLogin
			.logout( (logout) -> logout.logoutRequestMatcher( new AntPathRequestMatcher("/user/logout") )
										.logoutSuccessUrl("/")
										.invalidateHttpSession(true) ) // logout
		;
		return http.build();
	} // filterChain

} // class






