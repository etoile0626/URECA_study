package servletstudy;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(value = "/s10")
public class S10Cookie extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8"); //charset과 같은 기본적인 정보들을 설정?
		PrintWriter out = resp.getWriter();
		
		//Cookie c1 = new Cookie("cookie_test_1", "test_1_5642153"); //name, value를 쿠키에 넣어 생성, 값에 띄어쓰기 못씀
		Cookie c1 = new Cookie("cookie_test_1"
								, URLEncoder.encode("test no 1", "utf-8")); //이런 식으로 값을 URL로 따로 인코딩하면 가능함
		c1.setMaxAge(60*60*24);								//하루만큼 유효하도록 쿠키 설정
		resp.addCookie(c1);									//resp에 쿠키담기
		
		Cookie c2 = new Cookie("cookie_test_2"
				, URLEncoder.encode("test는 한글로 해보겠습니다 2", "utf-8")); //이런 식으로 값을 URL로 따로 인코딩하면 가능함(권장)
		c2.setMaxAge(60*60*24);								//하루만큼 유효하도록 쿠키 설정
		resp.addCookie(c2);									//resp에 쿠키담기
		
		Date date = new Date();
		out.print("현재 시간 : "+date);
		
		out.close();
	}
	
}
