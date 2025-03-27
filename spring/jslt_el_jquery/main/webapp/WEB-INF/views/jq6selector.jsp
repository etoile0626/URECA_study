<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq6</h1>
		<hr>
		
		<h1 class="odd">jq1</h1>
		<h1 class="even">jq2</h1>
		<h1 class="odd">jq3</h1>
		<h1 class="even">jq4</h1>
		<h1 class="odd">jq5</h1>
		<h1 class="even">jq6</h1>
		
		<script>
		$(document).ready(function(){
			$(".odd").click(function(){
				$(".odd").css("background-color", "aqua"); //css를 적용시켜주는 함수
				$(".even").css("background-color", "coral"); //css를 적용시켜주는 함수
			})
			
			$(".even").click(function(){
				$(".odd").css("background-color", "red"); //css를 적용시켜주는 함수
				$(".even").css("background-color", "blue"); //css를 적용시켜주는 함수
			})
		});
		</script>
		
<%@ include file="./footer.jsp" %>
