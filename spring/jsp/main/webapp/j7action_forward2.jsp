<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>j7action_forward2</h1>
		
		<!-- jsp 액션 태그 중 forward : forward를 조금더 편하게 쓰게 만들어줌 -->
		<jsp:forward page="j7action_forward3.jsp">
			<jsp:param value="010-9876-5432" name="add_data_tel"/> <!-- getParameter로 받을 수 있음 -->
			<jsp:param value="naver@gamil.com" name="add_data_email"/>
		</jsp:forward>

<%@ include file="./footer.jsp" %>
