<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq3</h1>
		<hr>
		
		<h1>id selector : id를 통해 html element에 접근(# 사용)</h1>
		<div id ="baguni" style="height:50px"; border="2px solid blue";></div>
		<input type="checkbox" value="죠스바">죠스바<br>
		<input type="checkbox" value="쌍쌍바">쌍쌍바<br>
		<input type="checkbox" value="누가바">누가바<br>
		<input type="checkbox" value="바밤바">바밤바<br>
		<input type="checkbox" value="설레임">설레임<br>
		
		<script>
		//얘를 만들어주는게 좋음
		$(document).ready(function(){
			$("input[type=checkbox]").click(function(){
				//$("#baguni").append(this.value); 아래가 좀더 jqeury스럽게 바꾼 것
				$("#baguni").append($(this).val());
			}); 
		});
		</script>
<%@ include file="./footer.jsp" %>
