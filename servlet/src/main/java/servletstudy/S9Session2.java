package servletstudy;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value="/s92")
public class S9Session2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();	//세션 가져오기
		System.out.println( session.getId());
		System.out.println( session.getMaxInactiveInterval());		//최대 사용시간
		System.out.println( session.getCreationTime());				//생성 시각
		System.out.println( session.getLastAccessedTime());			//마지막 접속 시각
		
		System.out.println(session.getAttribute("data_share_1"));
		System.out.println(session.getAttribute("data_share_2"));
		
		session.setMaxInactiveInterval(60*60*24); //최대 사용시간 하루로 세팅
		System.out.println( session.getMaxInactiveInterval());		//최대 사용시간ㄴ
		
		session.removeAttribute("data_share_1"); //세션에 있는 데이터는 직접 지워줘야함
		System.out.println(session.getAttribute("data_share_1"));
	}
}
