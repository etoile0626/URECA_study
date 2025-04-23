package kr.co.ureca.exception;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.ureca.dto.EntryPointErrorResponse;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		System.out.println("CustomAuthenticationEntryPoint - commence");
		System.out.println("[coomence] 인증 실패로 responese.sendError 발생");
		
		EntryPointErrorResponse entryPointErrorResponse = new EntryPointErrorResponse(); 
		entryPointErrorResponse.setMsg("인증이 실패하였습니다.");
		
		response.setStatus(401); //401 오류 코드 주기(권한 없음을 의미)
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(objectMapper.writeValueAsString(entryPointErrorResponse));
	}

}
