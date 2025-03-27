<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    				<!-- core말고도 3종류 더 있음 /  core는 관습적으로 prefix에 c를 넣음-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl을 쓰기위해 반드시 필요한 링크 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- fmt 종류도 추가 -->
<%@ page import="java.util.Date" %>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jstl8</h1> <!-- 내 맘대로 패턴을 만들어 출력? -->
		<hr>
		<h1>jstl fmt : formating : 숫자 / 날짜 형식</h1>
		<c:set var="price" value="1000000000"/>
		
		<fmt:formatNumber type="number" var="numPrice" value="${price }"/>
		<h3>${numPrice }</h3>
		<fmt:formatNumber type="currency" var="curPrice" value="${price }"/>
		<h3>${curPrice }</h3>
		<fmt:formatNumber type="currency" var=dolPrice" currencySymbol="$" value="${price }"/>
		<h3>${dolPrice }</h3>
		<fmt:formatNumber type="percent" var="perPrice" value="${price }"/>
		<h3>${perPrice }</h3>
		
		
		<c:set var="now" value="<%= new Date() %>" />
		<h3>date : ${ now }</h3>

		<hr>
		<h3>formatDate type="date" dateStyle="full" :
			<fmt:formatDate type="date" dateStyle="full" value="${ now }"/></h3>
		<h3>formatDate type="date" dateStyle="short" :
			<fmt:formatDate type="date" dateStyle="short" value="${ now }"/></h3>

		<hr>
		<h3>formatDate type="time" timeStyle="full" :
			<fmt:formatDate type="time" timeStyle="full" value="${ now }"/></h3>
		<h3>formatDate type="time" timeStyle="short" :
			<fmt:formatDate type="time" timeStyle="short" value="${ now }"/></h3>

		<hr>
		<h3>formatDate type="both" dateStyle="full" timeStyle="full" :
			<fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${ now }"/></h3>
		<h3>formatDate type="both" dateStyle="full" timeStyle="short" :
			<fmt:formatDate type="both" dateStyle="full" timeStyle="short" value="${ now }"/></h3>

		<hr>
		<h3>formatDate type="both" dateStyle="short" timeStyle="full" :
			<fmt:formatDate type="both" dateStyle="short" timeStyle="full" value="${ now }"/></h3>
		<h3>formatDate type="both" dateStyle="short" timeStyle="short" :
			<fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${ now }"/></h3>

		<hr>
		<h3>YYYY-MM-dd hh:mm:ss : <fmt:formatDate value="${ now }" pattern="YYYY-MM-dd hh:mm:ss"/></h3>
		<h3>YY/MM/dd HH:mm:ss : <fmt:formatDate value="${ now }" pattern="YY/MM/dd HH:mm:ss"/></h3>
		<h3>HH:mm:ss YY/MM/dd : <fmt:formatDate value="${ now }" pattern="HH:mm:ss YY/MM/dd"/></h3>
		
<%@ include file="./footer.jsp" %>
