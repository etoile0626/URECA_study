<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../header.jsp" %>
<%@ include file="../nav.jsp" %>

		<h1>USER Join</h1>
		<hr>
		<form action="/user/join/ins" method="post">
			<table>
				<tbody>
					<tr>
						<th>userName</th>
						<td><input type="text" name="username"></td>
						<th>password</th>
						<td><input type="text" name="password"></td>
					</tr>
				</tbody>
			</table>
			<div class="text-right">
				<button type="submit" class="btn btn-warning"> 회 원 가 입 </button>
			</div>
		</form>

<%@ include file="../footer.jsp" %>
