package servletstudy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/s62")
public class S6Include2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("getParameter : "+ req.getParameter("ename"));
		System.out.println(" getAttribute : "+ req.getAttribute("data_tran_1"));	//s6로 부터 데이터 전달받음
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>include test</title></head?<body>");
	
	}
}
