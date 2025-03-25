package servletstudy;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/s2")
public class S2LifeCycle extends HttpServlet{
	
	public S2LifeCycle() {
		System.out.println("1. 생성자 실행");
		
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("2. init 실행");
	}
	
	//서버 킨 상태로 이 코드 다시 실행하면 서비스만 돈다
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("3. service 실행");
	}
	
	@Override
	public void destroy() {
		System.out.println("4. destroy 실행");
	}
	
}
