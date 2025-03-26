package servletstudy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/s5")
public class S5Redirect extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//주소 전환 방법 3가지
		//1번 방법-sendRedirect => 많이 쓰임, restAPI에서 화면 전환시 필수
		//resp.sendRedirect("https://naver.com/");		//response=서버가 클라이언트에게 보내는 모든 내용
		
		//2번방법-addHeader
		//resp.addHeader("refresh", "10;url=https://naver.com/");	//url로 10초 후에 refresh 해주세요
		
		//3번방법-js로 스크립트에서 location으로 넘기기
		PrintWriter out = resp.getWriter();
		out.print("<body><script>");
		out.print("location.href='https://google.com/'");
		out.print("</script></body>");
		out.close();
		
		System.out.println("S5Redirect - doGet - after naver");
	}
	
}
