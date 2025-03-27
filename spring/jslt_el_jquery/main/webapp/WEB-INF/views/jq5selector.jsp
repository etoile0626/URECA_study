<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq5</h1>
		<hr>
		
		<button id="selectAllBtn"> 전 체 선 택 </button>
		<button id="deselectAllBtn"> 전 체 해 제 </button>
		<input type="checkbox" value="죠스바">죠스바<br>
		<input type="checkbox" value="쌍쌍바">쌍쌍바<br>
		<input type="checkbox" value="누가바">누가바<br>
		<input type="checkbox" value="바밤바">바밤바<br>
		<input type="checkbox" value="설레임">설레임<br>
		
		<script>
		let checkboxLength = 0;
		$(document).ready(function(){
			checkboxLength = $(":checkbox").length;
			
			$("#selectAllBtn").click(function(){
				//prop() 메소드: 속성의 값을 가져오거나 집어 넣는 jquery 함수
				$(":checkbox").prop("checked", true); //체크박스를 전부 체크상태로 바꿔라
			});
			
			$("#deselectAllBtn").click(function(){
				$(":checkbox").prop("checked", false); //체크박스를 전부 체크상태로 바꿔라
				
			});
		});
		</script>
<%@ include file="./footer.jsp" %>
