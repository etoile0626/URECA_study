package servletstudy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/s6")
public class S6Include extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("S6Include - doGet - START");
		
		req.setAttribute("ename", "modi");
		req.setAttribute("data_tran_1", "s6에서 전달하는 데이터입니다."); //name, value 형태
		
		//request를 dispatcher(분기) 하는 애
		RequestDispatcher rd = req.getRequestDispatcher("/s62"); //분기할 곳 지정
		rd.include(req, resp);							//include : 다른 파일을 복사해와 붙여 넣는 개념
									//복붙 후 컴파일함 -> 자바파일은 s6 s62 2개지만 클래스파일은 s6하나임!
		PrintWriter out = resp.getWriter();
		out.print("<h1> include test success! </h1>");
		out.print("</body></http>");
		out.close();
		
		System.out.println("S6Include - doGet - END");
	}
}
