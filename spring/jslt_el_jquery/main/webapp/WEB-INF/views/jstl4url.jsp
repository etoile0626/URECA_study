<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    				<!-- core말고도 3종류 더 있음 /  core는 관습적으로 prefix에 c를 넣음-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl을 쓰기위해 반드시 필요한 링크 -->
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jstl4</h1>
		<hr>
		<h1>c:url : url을 지정하는 역할 + request.setParameter(파라미터 전송)의 역할</h1>
		<!-- value : 서버 주소를 의미 -->
		<c:url var="urlVar" value="/jstl5" >
			<c:param name="bno" value="213"/>
			<c:param name="btitle" value="사람은 무엇으로 사는가?"/>
			<c:param name="bwriter" value="톨스토이"/>
			<c:param name="bcnts" value="철학, 종료"/>
			<c:param name="bdate" value="1845-08-15"/>
		</c:url> <!-- 이 상태로는 전송 안됨 써먹어야 되는거임 -->
		<!-- 여기서 이 링크를 누르면 같이 데이터가 전송되면서 url로 이동 -->
		<a href="${urlVar }">jstl5로 바로 가기</a> 
<%@ include file="./footer.jsp" %>
