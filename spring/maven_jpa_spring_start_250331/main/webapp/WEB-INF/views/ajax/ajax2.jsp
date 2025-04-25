<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>
<%@ include file="../nav.jsp" %>

		<h1>welcome!</h1>
		<hr>
		<h2>emp empno 중복 체크</h2>
		<h5 id="duplicateMessage"></h5>
		<input type="text" class="form-control" id="empno" name="empno">
		<button class="btn btn-primary" id="btn1">empno 중복체크</button>
		<script>
		$(document).ready(function(){
			$("#btn1").click(function(){
				$.post(
					"${pagecontext.request.contextPath}/ajax-api/ajax2"
					, {empno: $("#empno").val()}
					, function(data, status){
						if(data == 0){	//not duplicate
							$("#duplicateMessage").text("사용 가능한 사번입니다.")
							$("#duplicateMessage").css("color", "green")
						} else if(data > 0){ //duplicate
							$("#duplicateMessage").text("이미 사용 중인 사번입니다.")
							$("#duplicateMessage").css("color", "red")
						}
					}
				);
			})
		})
		</script>
<%@ include file="../footer.jsp" %>
