<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>j3include_file</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="./nav.jsp" %> <!-- css가 header.jsp에 있어서 아마 깨져보일거임->그래서 붙여옴 -->
	<h1>&lt%@ include는 Servlet의 RequsetDispatcher.iclude(res, resp)와 같은 애임</h1>
	<h1>&lt%@ include file은 다른 소스 파일을 '복사' 해서 선언된 위치에 붙이고, 함께 자바 파일 변환/컴파일/실행하라는 뜻</h1>
	<h2>->실제로 톰캣서버 파일 찾아가보면 nav.jsp는 없고 j3iclude_file.jsp가 변환된 class 밖에 없는 것을 확인해 검증 완료</h2>
</body>
</html>