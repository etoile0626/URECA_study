<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq15</h1>
		<hr>
		
		<div id="div1"></div>

		<button id="btn1">Add Class</button>
		<button id="btn2">Remove class</button>
	

		<script>
		$(document).ready(function(){
			$("#btn1").click(function(){
				$("#div1").addClass("boxStyle");
			})
			
			$("#btn2").click(function(){
				$("#div1").removeClass("boxStyle");
			})
			
		});
		</script>
		
		
<%@ include file="./footer.jsp" %>
