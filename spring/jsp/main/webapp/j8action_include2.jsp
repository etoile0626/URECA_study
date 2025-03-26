<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>j8action_include2</h1>
		
		<!-- 3번 파일은 2번 파일과 합쳐져서 돌아감->.java도 .class도 없음 -->
		<%@ include file="j8action_include3.jsp" %>	<!-- 파라미터 없이 그냥 보냄 -->
		
		<!-- 
			@include file 방식 : 파일을 합쳐서 하나로 만든 후 함께 변환/컴파일/실행 
			jsp:include page 방식 : 따로 변환/컴파일/실행 후 결과만 합침
		-->
		
		<!-- 근데 얘처럼 jsp 액션태그로 하면 다름-> 결과는 같아 보이나 4번 파일이 따로 변환되어 존재함 -->
		<!-- 단순히 변환된 결과를 갖다 붙임 -->
		<jsp:include page="./j8action_include4.jsp">
			<jsp:param value="010-9876-5432" name="add_data_tel"/>
			<jsp:param value="naver@gamil.com" name="add_data_email"/>
		</jsp:include>

<%@ include file="./footer.jsp" %>
