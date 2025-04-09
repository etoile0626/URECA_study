<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../header.jsp" %>
<%@ include file="../nav.jsp" %>

		<h1>EMP LIST</h1>
		<hr>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>No</th>		<th>Empno</th>	<th>Ename</th>
					<th>Job</th>	<th>Mgr</th>	<th>Hiredate</th>
					<th>Sal</th>	<th>Comm</th>	<th>Deptno</th>
				<tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${emp_list}" varStatus="status">
					<tr>
						<td>${dto.id}</td>	<td>${dto.empno}</td>
						<td><a href="/api1/emp/detail/${dto.id}">${dto.ename}</a></td>
						<td>${dto.job}</td>	<td>${dto.mgr}</td>		<td>${dto.hiredate}</td>
						<td>${dto.sal}</td>	<td>${dto.comm}</td>	<td>${dto.deptno}</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>

<%@ include file="../footer.jsp" %>
