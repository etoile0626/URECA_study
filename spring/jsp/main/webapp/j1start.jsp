<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- @page태그 = jsp에 대한 설정 작업, page에 대한 설정 중 -> 아래 처럼 자바 라이브러리 import도 가능-->
<%@page import="java.util.ArrayList, java.util.HashSet"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp tag : 주석 태그, 선언태그(멤버 변수/메소드), 출력태그, @page 태그(jsp 설정), 일반 태그(scriptlet 태그)</h1>
	<!-- html 주석 태그 -->
	<%-- jsp 주석 태그, 이건 소스보기에서 안 보임-> html, scc, js 다 보이는데 얘는 안보임 --%>
	<%-- jsp 주석이 보이지 않는 이유 : a.jsp -> a_jsp.java -> a_jsp.class로 변환되는 과정에서 주석이 제외되기에 --%>
	<hr>
	<h1>JSP 선언 태그 : 멤버 변수, 멤버 메소드 선언, 태그에 !포함, 세미콜론 필요 </h1>
	<%! String strVar = new String("My name is yoon"); %>
	<%! 
		//jsp 태그 안에서는 java 주석 사용이 가능하더라
		public int sum (int a, int b){						//메소드 이름을 우리가 선언할 수 있음
			System.out.printf("%d + %d = %d", a, b, a+b);	//서버 콘솔에 출력
			return a+b;
		}
	%>
	<hr>
	<h1>JSP 출력 태그 : =</h1>
	strVar : <%= strVar %> <!-- out.print(strVar);와 동일 -->
	<br>
	sum(7, 8) : <%= sum(7, 8) %>
	<hr>
	<h1>JSP Scriptlet 태그 : 메소드 태그 : 자바 코드 작성 : 변수 선언 시, 지역 변수가 된다.</h1>
	<%
		ArrayList<String> sports = new ArrayList<>();
		sports.add("야구"); sports.add("농구"); sports.add("축구");
	%> 
	sports :  <%= sports %>
</body>
</html>