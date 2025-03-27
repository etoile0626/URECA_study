<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>
	<h1> EL을 통해 jsp 페이지에서 객체를 받아주는 부분을 자동처리</h1>
	<h2>${ msgFromRequset }</h2>
	<h2>${ msgFromSession }</h2>
	<hr>
	<h2>${ board_dto.getBno() }</h2> <!-- 이런 식으로도 가능 -->
	<h2>${ board_dto.btitle }</h2>
	<h2>${ board_dto }</h2>
	<hr>
	<h2>empty dto : dto is null? ${ empty board_dto }</h2>
	<h2>not empty dto : dto is not null? ${ not empty board_dto }</h2>
	<hr>
	<h2>empty "" : ${ empty ""} </h2> <!-- String 객체 자체가 생성이 안됐다고 판단해서 true -->
	<h2>empty " " : ${ empty " "} </h2>
	<h2>empty null : ${ empty null} </h2>
<%@ include file="./footer.jsp" %>