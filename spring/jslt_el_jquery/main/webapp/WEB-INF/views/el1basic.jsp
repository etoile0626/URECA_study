<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>
	<h1>EL : expression language : $와 중괄호를 사용한 출력 표현</h1>
	<h2>${ 1 + 1 } : out.print( 1 + 1 ) = > jsp 출력 태그의 다른 모습</h2>
	<!-- 이거 어디서 많이 봤는데 ${name}..?-->
	
	<h2>+ : ${ "10" + 1 } : ${ null + 1 } : ${ "10" + "10" }</h2>
	<h2> +-*/% 다 가능 : ${ 123 + 4 } : ${ 123 - 4 } : ${ 123 * 4 } : ${ 123 / 4 } : ${ 123 % 4 }</h2>
	<hr>
	<h2>div mod : ${123 div 4 } : ${123 mod 3 }</h2>
	<h2>eq ne : ${123 == 4} : ${ 123 eq 4} : ${123 != 4 } : ${123 ne 4 }</h2>
	<h2>gt lt : 크다 / 작다</h2>
	<h2>ge le : 크거나 같다 / 작거나 같다</h2>
	<hr>
	<h2>and : ${ true and 0 < 1}</h2>
	<h2>or :  ${ false or 0 < 1}</h2>
	<h2>not : ${ !true } : ${ not false }</h2>
	<h2>3항 연산자 : ${ (1<3)? "참": "거짓" }</h2>

<%@ include file="./footer.jsp" %>