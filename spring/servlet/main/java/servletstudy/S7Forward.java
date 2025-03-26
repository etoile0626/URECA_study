package servletstudy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/s7")
public class S7Forward extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("S7Forward - doGet - START");
		
		req.setAttribute("ename", "modi");
		req.setAttribute("data_tran_1", "s6에서 전달하는 데이터입니다."); //name, value 형태
		
		RequestDispatcher rd = req.getRequestDispatcher("/s72");
		rd.forward(req, resp);					//forward로 값 전송 ->/s72에서 response를 보내고 끝남
		
		PrintWriter out = resp.getWriter();
		out.print("<body bgcolor=aqua>");
		out.print("<h1> forward test success! </h1>");
		out.print("</body>");
		out.close();												//그래서 이 out 문이 무시가 됨
		
		System.out.println("S7Forward - doGet - END");
	}
}
