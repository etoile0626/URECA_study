<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    				<!-- core말고도 3종류 더 있음 /  core는 관습적으로 prefix에 c를 넣음-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl을 쓰기위해 반드시 필요한 링크 -->
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jstl3</h1>
		<hr>
		<h1>c:foreach</h1>
		<h3>myList : ${myList }</h3>
				<!-- var : items에서 하나씩 담을 변수 / varStatus는 항상 이렇게 쓰기 -->
		<c:forEach var="str" items="${myList }" varStatus="status">
					<!-- status는 몇번 반복문이 돌았나 기억해줌, index는 0에서, count는 1에서 시작 -->
			<h3>${ str } : ${ status.index } : ${ status.index }</h3>
		</c:forEach>
		<hr>
		<h4>items : 반복문을 수행할 객체. ex)List</h4>
		<h4>for (String str : myList)</h4>
		<h4>varStatus : 반복문의 반복횟수를 기억하는 변수</h4>
		<h4>varStatus.index : 0에서 시작</h4>
		<h4>varStatus.count : 1에서 시작</h4>
		<hr>
		<c:forEach var="dto" items="${ board_list }" varStatus="status">
			<h3>${ dto.btitle } : ${ dto.bwriter } : ${ dto }</h3>
		</c:forEach>
		<hr>
		<c:set var="fruits" value="apple,banana,cherry,melon,peach"/>
		<!-- c:forTokens : 구분자(delims)를 기준으로 문자열 잘라줌 -->
		<c:forTokens var="fruitVar" items="${fruits }" delims="," varStatus="status">
			<h3>${status.index} : ${status.count } : ${fruitVar }</h3>
		</c:forTokens>
		<hr>
		<!-- 이런것도 되넹 -->
		<c:forEach var="num" begin="1" end="20" step="2">
			${ num }<br>
		</c:forEach>
<%@ include file="./footer.jsp" %>
