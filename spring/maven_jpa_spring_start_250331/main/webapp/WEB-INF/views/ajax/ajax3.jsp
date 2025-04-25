<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>
<%@ include file="../nav.jsp" %>

		<h1>AJAX 3</h1>
		<hr>
		<table class="table table-hover">
			<thead>
				<th>사번</th> <th>이름</th> <th>직업</th> <th>사수</th>
				<th>입사일</th> <th>급여</th> <th>성과급</th> <th>부서번호</th>
			</thead>
			<tbody id="tbody"></tbody>
		</table>
		<hr>
		
		<script>
		$(document).ready(function(){
			$.get(
				"${pagecontext.request.contextPath}/ajax-api/ajax3"		
				//, {}	//보낼 데이터가 없음
				, function(data, status){
					
					$.each(data, function(idx, dto){
						$("#tbody").append(
							"<tr>"
							+"<td>" + dto.empno + "</td>"
							+"<td>" + dto.ename + "</td>"
							+"<td>" + dto.job + "</td>"
							+"<td>" + dto.mgr + "</td>"
							+"<td>" + dto.hiredate + "</td>"
							+"<td>" + dto.sal + "</td>"
							+"<td>" + dto.comm + "</td>"
							+"<td>" + dto.deptno + "</td>"
							+"</tr>"
						);
					});
					
				}
			);
		})
		</script>
<%@ include file="../footer.jsp" %>
