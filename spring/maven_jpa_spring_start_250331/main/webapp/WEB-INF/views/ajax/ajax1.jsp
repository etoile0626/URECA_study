<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>
<%@ include file="../nav.jsp" %>

		<h1>AJAX 1</h1>
		<hr>
		<h2>AJAX : Asynchronous Javascript And Xml</h2>
		<h3>Asynchronous : 동시에 일어나지 않는다 => 화면 전환과 데이터 전송이 동시에 일어나지 않는다!</h3>
		<h3>Asynchronous : 화면은 그대로 있고, 서버와 보이지 않는 통신을 하는 것</h3>
		<h3>Javascript : 동작은 자바 스크립트로 진행</h3>
		<h3>Xml : 통신 방식은 Xml => XmlHttpRequest, XmlHttpResponse</h3>
		<hr>
		<h1 id="txtFromServer">메세지 변경을 위한 공간</h1>
		<button id="btn1"> jQuery AJAX 실행 - Get </button>
		<button id="btn2"> jQuery AJAX 실행 - Post</button>
		<h2> JSP Project Root Path : ${pagecontext.request.contextPath}</h2>
									<!-- jsp 프로젝트의 루트 패스(지금은 "/")를 의미? -->
		<hr>
		<script>
			$(document).ready(function(){
				$("#btn1").click(function(){
					//http get 메소드 통신 하는 AJAX 표현
					$.get(
							//첫번째 자리 : 서버 주소 (""안에 넣기)
							"${pagecontext.request.contextPath}/ajax-api/ajax1"
							//두번째 자리 : 서버로 전송하는 데이터 (중괄호로 묶기), 생략 가능
							, {name:"HGD", email:"mail@email.com"}
							//세번째 자리 : 서버가 호출해주는 call back function
							//data는 서버가 보내는 데이터, "status는 통신 성공 여부"를 의미!!
							//서버 에러가 나도 통신 성공하면 success라는 뜻!! (fail이 되려면 서버와 아예 접속이 안되어야함)
							, function(data, status){
								$("#txtFromServer").text(status + " : " + data)}
							}
							//네번째 자리 : 서버에서 주는 데이터 형식 (ex.json), 없을 경우 생략 가능
					);
				})
			})
			
			$(document).ready(function(){
				$("#btn2").click(function(){
					//http post 메소드 통신 하는 AJAX 표현
					$.post(
							//첫번째 자리 : 서버 주소 (""안에 넣기)
							"${pagecontext.request.contextPath}/ajax-api/ajax1"
							//두번째 자리 : 서버로 전송하는 데이터 (중괄호로 묶기), 생략 가능
							, {name:"HGD", email:"mail@email.com"}
							//세번째 자리 : 서버가 호출해주는 call back function
							//data는 서버가 보내는 데이터, "status는 통신 성공 여부"를 의미!!
							//서버 에러가 나도 통신 성공하면 success라는 뜻!! (fail이 되려면 서버와 아예 접속이 안되어야함)
							, function(data, status){
								$("#txtFromServer").text(status + " : " + data)}
							}
							//네번째 자리 : 서버에서 주는 데이터 형식 (ex.json), 없을 경우 생략 가능
					);
				})
			})
		</script>
<%@ include file="../footer.jsp" %>
