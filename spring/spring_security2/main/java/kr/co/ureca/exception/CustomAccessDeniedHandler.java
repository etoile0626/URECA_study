package kr.co.ureca.exception;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		System.out.println("CustomAccessDeniedHandler - handle");
		System.out.println("[handle] 접근이 막혔을 경우 경로 리다이렉트");
		
		response.sendRedirect("/sign-api/exception");
	}

}
