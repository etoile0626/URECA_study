package servletstudy;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/s82")
public class S8Context2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//ServletContext : 프로젝트 실행 환경, 이를 통해서도 데이터 공유가 가능
		ServletContext sc = getServletContext();		//ServletContext 가져오기
		System.out.println(sc.getAttribute("data_share_1"));
		System.out.println(sc.getAttribute("data_share_2"));
		
		
	}
}
