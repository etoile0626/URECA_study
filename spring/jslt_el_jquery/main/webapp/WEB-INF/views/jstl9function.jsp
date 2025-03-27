<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    				<!-- core말고도 3종류 더 있음 /  core는 관습적으로 prefix에 c를 넣음-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl을 쓰기위해 반드시 필요한 링크 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jstl9</h1>
		<hr>

		<h1>jstl fn : jstl functions</h1>
		<h3> <c:set var="str" value="Nice To Meet You, Too." /> </h3>
		<h3>str : ${ str }</h3>

		<hr>
		<c:set var="strArr" value='${ fn:split(str, " ") }' />
		<c:forEach var="strlet" items="${ strArr }">
			<h3>${ strlet }</h3>
		</c:forEach>

		<hr>
		<h3>fn:replace(str, "You", "U~~") : ${ fn:replace(str, "You", "U~~") } </h3>
		<h3>fn:substring(str, 3, 11) : ${ fn:substring(str, 3, 11) }</h3>
		<hr>
		<h3>fn:indexOf(str, "You") : ${ fn:indexOf(str, "You") }</h3>
		<h3>fn:startsWith(str, "Ni") : ${ fn:startsWith(str, "Ni") }</h3>
		<h3>fn:endsWith(str, "o.") : ${ fn:endsWith(str, "o.") }</h3>
		<hr>
		<h3>fn:length(str) : ${ fn:length(str) }</h3>
		<h3>fn:toLowerCase(str) : ${ fn:toLowerCase(str) }</h3>
		<h3>fn:toUpperCase(str) : ${ fn:toUpperCase(str) }</h3>
		<hr>
		<h3>fn:contains(str, "meet") : ${ fn:contains(str, "meet") }</h3>
		<h3>fn:containsIgnoreCase(str, "meet") : ${ fn:containsIgnoreCase(str, "meet") }</h3>
		<h3></h3>

<%@ include file="./footer.jsp" %>
