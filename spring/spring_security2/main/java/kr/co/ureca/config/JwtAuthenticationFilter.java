package kr.co.ureca.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.ureca.service.UserDetailsServiceImpl;

public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	private final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
	
	private JwtTokenProvider jwtTokenProvider; //얘랑 밀접하게 연관되어 있음?
	
	//생성자를 통해 의존성 주입 중
	public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = jwtTokenProvider.resolveToken(request);
		
		logger.info("doFilterInternal - token : " + token);
		
		//token이 null이 아니고 token이 정상일때 Authentication 가져오기
		if(token != null && jwtTokenProvider.validateToken(token)) {
			Authentication authentication = jwtTokenProvider.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
	}
	
}
