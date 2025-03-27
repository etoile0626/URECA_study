<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq2</h1>
		<hr>
		
		<h2><sup>element</sup>에 접근하는애 =<b>element selector</b></h2>
		<button id="btn1">get text</button>
		<button id="btn2">get html</button>

		<h4>html() : html을 가져오거나 집어넣는 jquery함수 (=innerHTML)</h4>
		<h4>text() : 글자를 가져오거나 집어넣는 jquery함수 (=textContents)</h4>

		<script>
		$("#btn1").click(function(){
			alert($("h2").text());
			$("h2").text("<b>get text</b> complete!"));  //단순 텍스트로 삽입
		});
		$("#btn2").click(function(){
			alert($("h2").html());							//
			$("h2").html("<font color=red>get html complete!</font>")); //실행가능한 html 태그도 적용
		});
		</script>
<%@ include file="./footer.jsp" %>
