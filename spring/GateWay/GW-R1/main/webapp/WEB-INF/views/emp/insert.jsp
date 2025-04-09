<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../header.jsp" %>
<%@ include file="../nav.jsp" %>

		<h1>EMP Insert</h1>
		<hr>
		<form action="/api1/emp/insert" method="post"><
			<table>
				<tbody>
					<tr>
						<th>Empno</th>
						<td><input type="number" min="0" name="empno"></td>
						<th>Ename</th>
						<td><input type="text" name="ename"></td>
					</tr>
					<tr>
						<th>Job</th> 
						<td><input type="text" name="job"></td>
						<th>Mgr</th>
						<td><input type="number" min="0" name="mgr"></td>
					</tr>
					<tr>
						<th>Deptno</th>
						<td><input type="number" min="0" name="deptno"></td>
						<th>Hiredate</th>
						<td><input type="date" name="hiredate"></td>
					</tr>
					<tr>
						<th>Sal</th>
						<td><input type="number" min="0" name="sal"></td>
						<th>Comm</th>
						<td><input type="number" min="0" name="comm"></td>
					</tr>
				</tbody>
			</table>
			<div class="text-right">
				<button type="submit" class="btn btn-warning"> 사 원 등 록 </button>
			</div>
		</form>

<%@ include file="../footer.jsp" %>
