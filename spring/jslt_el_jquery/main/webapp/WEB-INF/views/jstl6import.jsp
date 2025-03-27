<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    				<!-- core말고도 3종류 더 있음 /  core는 관습적으로 prefix에 c를 넣음-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl을 쓰기위해 반드시 필요한 링크 -->
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jstl6</h1>
		<hr>
		<h1>c:import : url에 있는 다른 jsp 페이지를 변환/컴파일/실행 후 실행 결과만 가져옴 - jsp:include를 구현한 애?</h1>
		<h2>(변수 공유 불가)</h2>
		<h3>include file 방식의 경우 '복사' 후 변환/컴파일/실행 이므로 변수 공유 가능</h3>
		<c:import url="./jstl5url2.jsp">
		<!-- 변수를 c:param으로 넘겨야함 -->
			<c:param name="bno" value="213"/>
			<c:param name="btitle" value="폭풍의 언덕"/>
			<c:param name="bwriter" value="에밀리 브론테"/>
			<c:param name="bcnts" value="드라마"/>
			<c:param name="bdate" value="1899-08-15"/>
		</c:import>

<%@ include file="./footer.jsp" %>
