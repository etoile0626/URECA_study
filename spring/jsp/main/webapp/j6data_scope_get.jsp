<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>j6data_scope_get</h1>
		
		<hr>
		<h2>request scope</h2>
		<h3><%= request.getAttribute("bookName1") %></h3>
		<h3><%= request.getAttribute("customer") %></h3>
		
		<hr>
		<h2>session scope</h2>
		<%-- session.invalidate(); --%> <!-- 세션 없애는 메소드, 이거 하면 getAttribute 자체가 불가능해짐 -->
		<h3><%= session.getAttribute("bookName1") %></h3>
		<h3><%= session.getAttribute("customer") %></h3>
		
		<hr>
		<h2>application scope</h2>
		<h3><%= application.getAttribute("bookName1") %></h3>
		<h3><%= application.getAttribute("customer") %></h3>
		
		<hr>
		<h2>data의 전달 범위 = Scope</h2>
		<h3>page scope : jsp 현재 페이지에서만, 페이지를 벗어나면 사라짐(고민할 의미가 없음)</h3>
		<h3>request scope : 클라이언트의 request를 통해 data 공유 (서버가 응답하면 request 자체가 소멸-같이 사라짐)
						  : 웬만하면 이거 사용하는게 좋음</h3>
		<h3>session scope : session을 통해 data 공유 (session에 담는 느낌?)
						  : 로그아웃, 세션타임아웃, 클라리언트 브라우저 종료 시 소멸</h3>
		<h3>application scope (= context scope): 웹 애플리케이션 실행환경에 데이터를 던져둠(서버 꺼질 때까지 남아있음)</h3>
<%@ include file="./footer.jsp" %>
