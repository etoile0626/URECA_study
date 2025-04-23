package kr.co.ureca.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import kr.co.ureca.exception.CustomAccessDeniedHandler;
import kr.co.ureca.exception.CustomAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) //
public class SecurityConfig {
	private JwtTokenProvider jwtTokenProvider;
	
	public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
		
		http.httpBasic(HttpBasicConfigurer::disable)
			.csrf(CsrfConfigurer::disable)					//rest api라 disable 해도 됨
			.cors(cors -> cors.configurationSource(this.configurationSource()))	//cors(출처가 다른 서버 간의 리소스 공유?) 해결 방법
			.sessionManagement(
					session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //rest api 방식에서는 stateless로
			.authorizeHttpRequests( 
					authorize -> authorize
										.requestMatchers("/emp/**").authenticated()	//emp에 대해 인증이 필요하다
										//.requestMatchers("/emp/**").hasRole("ADMIN") 
										.anyRequest().permitAll()	//모든 요청에 대해 permitall
			)
			.exceptionHandling(
					exception -> exception
									.accessDeniedHandler(new CustomAccessDeniedHandler())
									.authenticationEntryPoint(new CustomAuthenticationEntryPoint()) )
			//앞에서 선언한 이 설정들은 jwtauthentication필터 앞에 와야하고 UsernamePasswordAuthenticationFilter의 형태여야한다?
			.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
		;
		
		return http.build();
	}
	
	@Bean
	public CorsConfigurationSource configurationSource() {
		//cors 설정
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowCredentials(true);
		corsConfig.setAllowedOrigins(List.of("http://localhost:3000"));	//http주소는 여기에 있는 애만 허용
		corsConfig.setAllowedMethods(List.of("GET","POST","PUT","DELETE","PATCH","OPTIONS"));//http 메소드도 여기 나열된 애만 허용
		corsConfig.setAllowedHeaders(List.of("*"));	//모든 헤더를 허용하겠다
		corsConfig.setExposedHeaders(List.of("*"));
		
		UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
		corsSource.registerCorsConfiguration("/**", corsConfig); 	//모든 url에 cosrConfig를 적용하겠다
		
		return corsSource;
	}
}
