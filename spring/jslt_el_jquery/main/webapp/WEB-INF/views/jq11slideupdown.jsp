<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq11</h1>
		<hr>
		
		<h1>fade in&out</h1>
		<button id="btn1"> toggle button</button>
		<div id="title">오늘의 알림</div>	<!-- 이 타이틀을 누르면 contents가 보이는게 목푠 -->
		<div id="contents">
			<P>hi</P>
			<P>hello</P>
			<P>how are you</P>
			<P>i'm fine thx and you</P>
			<P>hi</P>
		</div>
		
		<script>
		$(document).ready(function(){
			
			let openYN = false;
			
			$("#contents").slideUp();
			
			$("#title").click(function(){
				if(!openYN){	
					//$("#contents").slideDown();
					$("#contents").slideDown(3000);
					openYN = true;
				} else if(openYN){			
					//$("#contents").slideUp();
					$("#contents").slideUp(3000);
					openYN = false;
				}
			});
			
			$("#btn1").click(function(){
				//$("#contents").slideToggle();
				$("#contents").slideToggle(1000);
			});
		});
		</script>
		
		
<%@ include file="./footer.jsp" %>
