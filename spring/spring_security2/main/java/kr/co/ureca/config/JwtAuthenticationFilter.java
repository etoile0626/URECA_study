package kr.co.ureca.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	private JwtTokenProvider jwtTokenProvider; //얘랑 밀접하게 연관되어 있음?
	
	//생성자를 통해 의존성 주입 중
	public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println("start JwtAuthenticationFilter - doFilterInternal");
		
		String token = jwtTokenProvider.resolveToken(request);	//토큰이 있나 확인 -> 없으면 토큰 생성
		
		System.out.println("JwtAuthenticationFilter - doFilterInternal - token : " + token);
		
		//token이 null이 아니고 token이 정상일때 Authentication 가져오기
		if(token != null && jwtTokenProvider.validateToken(token)) {
			Authentication authentication = jwtTokenProvider.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
	}
	
}
