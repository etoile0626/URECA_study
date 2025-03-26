<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>j2var_scope</title>
</head>
<body>
	<h1>&lt!에서 선언된 변수는 멤버 변수</h1>
	<h1>&lt에서 선언된 변수는 지역 변수</h1>
	
	<%! String str1 = new String("Hello"); %>	<!-- 멤버 변수 -->
	<% String str1 = new String("nice"); %>		<!-- 지역 변수 -->
	
	<h2>지역 변수 우선 : <%= str1 %></h2>
	<h2>멤버 변수는 this. 키워드로 접근 : <%= this.str1 %></h2>
	
</body>
</html>