<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>
	<form action="./s1" method="get"> <!-- form : 서버로 보내는 데이터들의 양식 -->
		이름 : <input type="text" name="ename">
		<input type="submit" value="Get 전송 버튼">
	</form>
	<form action="./s1" method="post"> <!-- form : 서버로 보내는 데이터들의 양식 -->
		직업 : <input type="text" name="job">
		<input type="submit" value="Post 전송 버튼">
	</form>
<%@ include file="./footer.jsp" %>
