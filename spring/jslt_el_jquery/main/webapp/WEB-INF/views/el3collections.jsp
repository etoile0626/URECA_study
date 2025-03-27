<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>e3!</h1>
		<hr>
		<h1>Model에서 Map 객체 받기</h1>
		<h2>${myMap.get("반장") }</h2>
		<h2>${myMap.get("부반장") }</h2>
		<h2>${myMap.get("부장") }</h2>
		<hr>
		<h1>Model에서 List 객체 받기</h1>
		<h2>${myList.get(0) }</h2>
		<h2>${myList.get(1) }</h2>
		<h2>${myList.get(2) }</h2>
<%@ include file="./footer.jsp" %>