<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../header.jsp" %>
<%@ include file="../nav.jsp" %>

		<h1>EMP Detail</h1>
		<hr>
		
		<table>
			<tbody>
				<tr>
					<th>No</th> <td colspan="3">${emp_detail.id}</td>
				</tr>
				<tr>
					<th>Empno</th>  <td>${emp_detail.empno}</td>
					<th>Ename</th> <td>${emp_detail.ename}"></td>
				</tr>
				<tr>
					<th>Job</th> <td>${emp_detail.job}</td>
					<th>Mgr</th> <td>${emp_detail.mgr}</td>
				</tr>
				<tr>
					<th>Deptno</th> <td>${emp_detail.deptno}</td>
					<th>Hiredate</th> <td>${emp_detail.hiredate}</td>
				</tr>
				<tr>
					<th>Sal</th> <td>${emp_detail.sal}</td>
					<th>Comm</th> <td>${emp_detail.comm}</td>
				</tr>
			</tbody>
		</table>
		

<%@ include file="../footer.jsp" %>
