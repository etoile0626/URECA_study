<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq13</h1>
		<hr>
		
		<table class="table">
			<thead>
				<tr>
    				<th>No</th> <th>Name</th> <th>Tel</th>
  				</tr>
			</thead>
			<tbody>
				<tr> <td>1</td> <td>apple</td> <td>010</td> </tr>
				<tr> <td>2</td> <td>banana</td> <td>011</td> </tr>
				<tr> <td>3</td> <td>cherry</td> <td>012</td> </tr>
				<tr> <td>4</td> <td>finapple</td> <td>013</td> </tr>
				<tr> <td>5</td> <td>graph</td> <td>014</td> </tr>
				<tr> <td>6</td> <td>mellon</td> <td>015</td> </tr>
			</tbody>
		</table>
		
		<button id="btn1"> 첫번째 요소 변경 </button>
		<button id="btn2"> 마지막 요소 변경 </button>
		<button id="btn3"> 첫번째 child 변경 </button>
		<button id="btn4"> 마지막 child 변경 </button>
		<button id="btn5"> clear </button>
		<hr>
		<input type="text" id="numtxt" placeholder="1~5 사이의 숫자 입력">
		<button id="btn6"> n번째child 변경 </button>
		<hr>
		<button id="btn7"> equal(3) </button>
		<button id="btn8"> less then(3) </button>
		<button id="btn9"> grater then(3) </button>

		<script>
		$(document).ready(function(){
			
			$("#btn1").click(function(){						//맨 윗줄만 변경됨
				$("tr:first").css("background-color", "red");
			});
			$("#btn2").click(function(){
				$("tr:last").css("background-color", "violet");
			});
			$("#btn3").click(function(){						//얘는 tr요소의 첫번째 child를 찾아서 적용
				$("tr:first-child").css("background-color", "orange");
			});
			$("#btn4").click(function(){						//얘는 tr요소의 마지막 child를 찾아서 적용
				$("tr:last-child").css("background-color", "green");
			});
			$("#btn5").click(function(){
				$("tr").css("background-color", "");
			});
			$("#btn6").click(function(){
				let tmpStr = $("#numtxt").val();		//input값 받아오기
				if($.trim(tmpStr) == "" || tmpStr > 5 || tmpStr < 1){	//trim(공백을 자른 값)
					alert("1~5 사이의 숫자 입력");
					return;				//공백이라 틀린거 넣으면 종료
				}
				//n번째 child 변경
				$("tr:nth-child("+tmpStr+")").css("background-color", "aqua");
			});
			$("#btn7").click(function(){
				//3번째인 애한테 적용
				$("tr:eq(3)").css("background-color", "coral");
			});
			$("#btn8").click(function(){
				//3보다 작은 애들에게 적용
				$("tr:lt(3)").css("background-color", "yellow");
			});
			$("#btn9").click(function(){
				//3보다 큰 애들에게 적용
				$("tr:gt(3)").css("background-color", "blue");
			});
		});
		</script>
		
		
<%@ include file="./footer.jsp" %>
