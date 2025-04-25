<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>
<%@ include file="../nav.jsp" %>

		<h1>AJAX 4</h1>
		<hr>
		<table class="table table-hover">
			<thead>
				<th>사번</th> <th>이름</th> <th>직업</th> <th>사수</th>
				<th>입사일</th> <th>급여</th> <th>성과급</th> <th>부서번호</th>
			</thead>
			<tbody>
				<tr>
					<td><input class="form-control" type="number" min="0" id="empno"></td>
					<td><input class="form-control" type="text" id="ename"></td>
					<td><input class="form-control" type="text" id="job"></td>
					<td><input class="form-control" type="number" min="0" id="mgr"></td>
					<td><input class="form-control" type="date" id="hiredate"></td>
					<td><input class="form-control" type="number" min="0" id="sal"></td>
					<td><input class="form-control" type="number" min="0" id="comm"></td>
					<td><input class="form-control" type="number" min="0" id="deptno"></td>
				</tr>
			</tbody>
		</table>
		<hr>
		<div class="text-right">
			<button class="btn btn-primary" id="btn1">SAVE</button>
		</div>
		
		<script>
		$(document).ready(function(){
			$("#btn1").click(function(){
				$.post(
					"${pagecontext.request.contextPath}/ajax-api/ajax4"		
					, {
						empno: $("#empno").val()
						, ename: $("#ename").val()
						, job: $("#job").val()
						, mgr: $("#mgr").val()
						, hiredate: $("#hiredate").val()
						, sal: $("#sal").val()
						, comm: $("#comm").val()
						, deptno: $("#deptno").val()
					}	
					, function(data, status){
						if(data > 0){
							alert("insert success");
							location.href="${pagecontext.request.contextPath}/ajax/ajax3";
						} else if(data <= 0){
							alert("insert fail");
						}
					}
				);
			}
		})
		</script>
<%@ include file="../footer.jsp" %>
