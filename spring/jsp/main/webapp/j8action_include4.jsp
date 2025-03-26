<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>j8action_include4</h1>
		<h3><%= request.getParameter("nickName") %></h3>
		<%
			String[] arr = request.getParameterValues("fruit");
			for(int i =0; i < arr.length; i++){
				out.print("<h3>"+arr[i]+"</h3>");
			}
		%>
		<h3><%= request.getParameter("add_data_tel") %></h3>
		<h3><%= request.getParameter("add_data_email") %></h3>

<%@ include file="./footer.jsp" %>
