<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq1start</h1>
		<hr>
		<h1>jquery : js를 쉽게 사용하기 위한 javascript library</h1>
		<h3>jquery.com 다운 or CDN 링크로 사용가능</h3>
		<h3>compressed 버전 : 해킹 방지 / 파일 사이즈 절감 목적으로 띄어쓰기 없이 작성된 버전</h3>
		<h3>uncompressed 버전 : 코드 확인이 가능하도록 가독성 있게 제공되는 버전</h3>
		
		<hr>
		
		<script>
		//$ = jquery를 의미 / $() = jquery를 실행한 대상 객체가 괄호 안으로
	//현재 페이지(document)가 ready(html 문서가 다 로딩된 상태)라면 뒤쪽 괄호 안의 함수를 실행함
		$(document).ready(function(){		//1회성 익명 함수
			alert("jquery execute");
		});
		</script>
		<hr>
		<h3>그래서 이거 왜 씀> -> html와 javascript를 분리해줌</h3>
		<button onclick="alert('jquery 사용 전')">jquery 사용 전</button>
		<button id="btn_test">jquery 사용 후</button>
		<script>
			$("#btn_test").click(function(){
				alret("사용 후");
			});
		</script>
<%@ include file="./footer.jsp" %>
