<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    				<!-- core말고도 3종류 더 있음 /  core는 관습적으로 prefix에 c를 넣음-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl을 쓰기위해 반드시 필요한 링크 -->
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jstl1!</h1>
		<hr>
		<h1>JSTL = Java Standard Tag Library</h1>
		<h3>JSTL : JSP를 쉽게 사용하기 위해 만들어진 라이브러리 </h3>
		<h3>링크가 "반드시"있어야 함 : &lt;% taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %&gt;</h3>
		<!-- 만약 prefix에 c 가 아니라 asdf를 넣으면 밑에서 쓰는 태그는 asdf:out과 같은 방식이 됨 -->
		<h3>c:out은 출력태그 : <c:out value="말 그대로 출력문"/> </h3>
		<hr>
		<h3>String tmp = c:set에 대입된 변수 값</h3>
		<h3><c:set var="tmp" value="c:set에 대입된 변수 값"/> </h3>
		<h3>근데 c:out은 변수 출력하려면 el 보다 복잡함<c:out value="${tmp} "/></h3>
		<h3>그럼 그냥 el 출력하지 : ${tmp}</h3>
<%@ include file="./footer.jsp" %>
