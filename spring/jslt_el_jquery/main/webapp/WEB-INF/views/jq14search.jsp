<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq14</h1>
		<hr>
		
		<!-- unordered list -->
		<ul>
			<li value="apple">apple</li>
			<li value="banana">banana</li>
			<li value="cherry">cherry</li>
			<li value="melon">melon</li>
			<li value="peach">peach</li>
			<li value="pinapple">pinapple</li>
			<li value="graph">graph</li>
			<li value="watermelon">watermelon</li>
		</ul>

		<button id="btn1">특정 문자열 p로 시작하는 요소 검색</button>
		<button id="btn2">특정 문자열 melon으로 끝나는 요소 검색</button>
		<button id="btn3">특정 문자열 ea를 포함하는 요소 검색</button>
		<button id="btn4">특정 문자열 cherry과 같은 요소 검색</button>
		<button id="btn5">특정 문자열 cherry과 다른 요소 검색</button>
		<button id="btn6">clear</button>

		<script>
		$(document).ready(function(){
			
			$("#btn1").click(function(){
				$("li[value^=p]").css("background-color", "red");
			});
			
			$("#btn2").click(function(){
				$("li[value$=melon]").css("background-color", "orange");
			});
			
			$("#btn3").click(function(){
				$("li[value*=ea]").css("background-color", "yellow");
			});
			
			$("#btn4").click(function(){
				$("li[value=cherry]").css("background-color", "green");
			});
			
			$("#btn5").click(function(){
				$("li[value!=cherry]").css("background-color", "skyblue");
			});
			
			$("#btn6").click(function(){
				$("li").css("background-color", "");
			});
		});
		</script>
		
		
<%@ include file="./footer.jsp" %>
