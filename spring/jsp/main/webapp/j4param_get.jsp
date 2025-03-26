<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>
		<h1>j4param_get</h1>
		<!-- request에서 nickName에 해당하는 파라미터 가져오기 -->
		<h2>nickName : <%= request.getParameter("nickName") %></h2>
		<h2>fruits : 
				<% out.print(Arrays.toString(request.getParameterValues("fruit"))); %> </h2>
		
		<h1>JSP 내장 객체 (위에서도 보면 썼음)</h1>
		<h2>HttpServletRequest request</h2>
		<h2>HttpServletResponse response</h2>
		<h2>PrintWriter out</h2>
		
		<% response.sendRedirect("https://www.naver.com/"); %> <!-- 이런 식으로 내장 객체 자유롭게 활용 가능 -->
<%@ include file="./footer.jsp" %>