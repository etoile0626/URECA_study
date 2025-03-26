<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>j6</h1>
		<h2>data의 전달 범위 = Scope</h2>
		<h3>page scope : jsp 현재 페이지에서만, 페이지를 벗어나면 사라짐(고민할 의미가 없음)</h3>
		<h3>request scope : 클라이언트의 request를 통해 data 공유 (서버가 응답하면 request 자체가 소멸-같이 사라짐)
						  : 웬만하면 이거 사용하는게 좋음</h3>
		<h3>session scope : session을 통해 data 공유 (session에 담는 느낌?)
						  : 로그아웃, 세션타임아웃, 클라리언트 브라우저 종료 시 소멸</h3>
		<h3>application scope (= context scope): 웹 애플리케이션 실행환경에 데이터를 던져둠(서버 꺼질 때까지 남아있음)</h3>
		<!-- 오래남아 있는다고 무조건 좋은건 아님! request scope를 보통 권장함 나머지는 어쩔 수 없을때만-->
		
		<%
			ArrayList<String> custList = new ArrayList<>();
			custList.add("MILLER"); custList.add("ADAMS"); custList.add("JAMES");
		%>
		
		<%
			request.setAttribute("bookName1", "축구의 이해");		//이렇게 단일객체도 전달가능하지만
			request.setAttribute("customer", custList);			//이런 컬렉션 개체도 전달가능하다
			
			session.setAttribute("bookName1", "축구의 이해");		//세션에서 데이터 공유
			session.setAttribute("customer", custList);	
			
			application.setAttribute("bookName1", "축구의 이해");	//웹 실행환경에서 데이터 공유
			application.setAttribute("customer", custList);	
		%>
		
		<!-- j6data_scope_get.jsp에 데이터 forward -->
		<% request.getRequestDispatcher("j6data_scope_get.jsp").forward(request, response); %>
		
		<!-- sendRedirect로 하면 request가 2번 일어나는 바람에 정보가 사라짐(request scope 단에서는 공유되는 데이터가 없어짐) -->
		<%-- response.sendRedirect("j6data_scope_get.jsp"); --%>
<%@ include file="./footer.jsp" %>