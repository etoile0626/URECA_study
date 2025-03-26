package servletstudy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/s72")
public class S7Forward2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("S7Forward2 - doGet - START");
		
		System.out.println("getParameter : "+ req.getParameter("ename"));
		System.out.println(" getAttribute : "+ req.getAttribute("data_tran_1"));
		
		PrintWriter out = resp.getWriter();
		out.print("<body bgcolor=coral>");
		out.print("<h1> forward test success! s72</h1>");
		out.print("</body>");
		//out.close();
		
		System.out.println("S7Forward2 - doGet - END");
	}
}
