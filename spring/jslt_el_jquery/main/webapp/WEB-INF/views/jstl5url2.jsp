<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    				<!-- core말고도 3종류 더 있음 /  core는 관습적으로 prefix에 c를 넣음-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl을 쓰기위해 반드시 필요한 링크 -->
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jstl5</h1>
		<hr>
		<h1>EL에서 param : request.getParameter의 의미</h1>
		<h3>글 번호 : ${param.bno }</h3>
		<h3>글 제목 : ${param.btitle }</h3>
		<h3>작성자 : ${param.bwriter }</h3>
		<h3>글 내용 : ${param.bcnts }</h3>
		<h3>작성일 : ${param.bdate }</h3>
<%@ include file="./footer.jsp" %>
