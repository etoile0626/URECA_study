<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>welcome!</h1>
		
		<jsp:useBean id="dto" class="jspstudy.dto.EmpDTO"/>
		<jsp:setProperty property="*" name="dto"/>
		
		<h1> <jsp:getProperty property="ename" name="dto"/></h1>
		<h1>dto : <%= dto %></h1>

<%@ include file="./footer.jsp" %>
