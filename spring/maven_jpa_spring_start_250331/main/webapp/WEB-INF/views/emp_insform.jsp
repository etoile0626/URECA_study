<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>emp_insert_form</h1>
		<hr>

		<!-- form action="/rest-test/no4" method="get" -->
		<!-- form action="/rest-test/no5" method="get" -->
		<!-- form action="/rest-test/no6" method="get"-->
		< form action="/rest-test/no7" method="post">
			<h3>사번 : </h3>
			<input type="number" name="empno">
			<h3>이름 : </h3>
			<input type="text" name="enmae">
			<h3>직업 : </h3>
			<input type="text" name="job">
			<h3>관리자 : </h3>
			<input type="number" name="mgr">
			<h3>입사일 : </h3>
			<input type="date" name="hiredate">
			<h3>급여 : </h3>
			<input type="number" name="sal">
			<h3>수당 : </h3>
			<input type="number" name="comm">
			<h3>부서번호 : </h3>
			<input type="number" name="deptno">
			<hr>
			<button type="submit"> 사 원 정 보 입 력 </button>
		</form>
<%@ include file="./footer.jsp" %>
