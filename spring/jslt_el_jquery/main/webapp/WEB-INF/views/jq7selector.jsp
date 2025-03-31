<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq7</h1>
		<hr>
		
		<h1>element attribute</h1>
		<h2>prop() : element 동적인 요소(변하는 상태값-체크박스의 체크 상태 등)를 가져오거나 변경하는 함수</h2>
		<h2>attr() : element 정적인 요소(변하지 않는 이름값)를 가져오거나 변경하는 함수</h2>
		
		<button id="btn1">image change</button>
		<br>
		<input type="checkbox" id="ch1"> test checkbox
		<br>
		<img src="/images/flower1.jfif" title="title : 봄꽃" alt="alt : 봄꽃입니다.">
		
		<script>
		%(document).ready(function(){
			$(btn1).click(function(){
				alert("alert : " + $("ch1").attr("checked"));		//attr에서는 checke여부를 뽈을 수 없음
				alert("alert : " + $("ch1").prop("checked"));		//얘는 됨 =>웬만한 prop은 attr을 대체 가능함
				$("img").attr("src", "/images/flower2.jfif");		//얘는 잘됨
				//$("img").prop("src", "/images/flower2.jfif");		//그럼 얘는?	
			});
		});
		</script>
		
<%@ include file="./footer.jsp" %>
