package servletstudy;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * cookie : 웹 브라우저에 저장하는 접속 정보?
 * -> 상대적으로 보안 취약, 도메인당(웹 사이트 당) 하나의 쿠키가 만들어짐
 * 저장용량에 제한이 있음(4kb)
 * 
 * session : 서버의 메모리에 접속 정보를 저장
 * 쿠키보다 상대적으로 보안이 좋음
 * 서버에 부하가 올 '수도' 있음
 * 클라이언트 브라우저 당 하나의 세션 생성
 * 유효시간 존재
 */
@WebServlet(value = "/s102")
public class S10Cookie2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		Cookie cookies[] = req.getCookies();
		for(Cookie cookie : cookies) {
			out.print("<h1>"+cookie.getName() 
						+" : "+cookie.getValue()
						+" : "+	URLDecoder.decode(cookie.getValue(), "utf-8")
						+" : "+	cookie.getMaxAge()+"</h1>");
		}
	}
	
}
