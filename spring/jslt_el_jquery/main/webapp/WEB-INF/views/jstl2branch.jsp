<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jstl2-branch</h1>
		<hr>
		<h1> c:if - 단일 if문 (else if, else 불가)  </h1>
		<h3>c:if test="${ boolBar == true}" : if(boolBar == true)</h3>
		<!-- boolVar를 true, false로 바꿔가며 테스트 -->
		<c:set var="boolVar" value="true"/>
		<c:if test="${boolVar == true }">
			<h3>boolVar가 ture 입니다.</h3>
		</c:if>
		<!-- else가 없어서 똑같은 분기문 한 번 더 사용 -->
		<c:if test="${boolVar == false }">
			<h3>boolVar가 false 입니다.</h3>
		</c:if>
		<hr>
		<h1> c:choose - 다중 if문 (else if, else 가능)  </h1>
		<h1>c:when ~ c:when :: if ~ else if</h1>
		<h1>c:otherwise :: else</h1>
		<c:set var="score" value="75"/>
		<c:choose>
			<c:when test="${ score > 90 }">
				<h3>A등급 입니다.</h3>
			</c:when>
			<c:when test="${ score > 80 }">
				<h3>B등급 입니다.</h3>
			</c:when>
			<c:when test="${ score > 70 }">
				<h3>C등급 입니다.</h3>
			</c:when>
			<c:when test="${ score > 60 }">
				<h3>D등급 입니다.</h3>
			</c:when>
			<c:otherwise>
				<h3>F등급 입니다.</h3>
			</c:otherwise>
		</c:choose>
<%@ include file="./footer.jsp" %>
