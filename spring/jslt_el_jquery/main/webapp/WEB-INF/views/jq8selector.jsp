<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq8</h1>
		<hr>
		
		<h1>group selector</h1>
		
		<button id="btn1"> group selector test </button>
		<h2> element selector 적용</h2>
		<h3 id="h3id"> id </h3>
		<h4 class="testCls"> class </h4>
		<h5 class="testCls"> class </h5>
		
		<script>
		let colorArr1 =["red", "orange", "yellow", "green", "skyblue", "blue", "purple"];
		let colorArr2 =["violet", "aqua", "coral", "yellowgreen", "gray", "pink"];
		let arrNum = 0;
		
		$(document).ready(function(){
			
			$("#btn1").click(function(){
				//이런식으로 여러개를 그룹으로 묶어 동시에 적용 가능
				$("h2, .testCls").css("background-color", colorArr1[arrNum%7]);	
				$("#h3id, .testCls").css("background-color", colorArr2[arrNum%6]);	
				arrNum++;
			});
		});
		</script>
		
<%@ include file="./footer.jsp" %>
