<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq16</h1>
		<hr>
		
		<table class="table">
			<thead>
				<tr>
    				<th>No</th> <th>Name</th> <th>Tel</th>
  				</tr>
			</thead>
			<tbody>
				<tr> <td>1</td> <td id="apple">apple</td> <td>010</td> </tr>
				<tr> <td>2</td> <td>banana</td> <td>011</td> </tr>
				<tr> <td>3</td> <td id="cherry">cherry</td> <td>012</td> </tr>
				<tr> <td>4</td> <td>finapple</td> <td>013</td> </tr>
				<tr> <td>5</td> <td>graph</td> <td>014</td> </tr>
				<tr> <td>6</td> <td>mellon</td> <td>015</td> </tr>
			</tbody>
		</table>
	
		<button id="btn0"> direct parent of apple </button>
		<button id="btn1"> all parents of apple </button>
		<button id="btn2"> parentsUntil(table) of apple </button>
		<button id="btn3"> all Children of tbody </button>
		<button id="btn4"> find() elements(cherry) of table </button>
		<button id="btn5">clear</button>
		<button id="btn6">sibling of tbody tr</button>
		<button id="btn7">prev sibling of cherry tr</button>
		<button id="btn8">next sibling of cherry tr</button>
		
		
		

		<script>
		$(document).ready(function(){
			$("#btn0").click(function(){
				//id가 apple인 애의 direct 부모를 찾아서 빨간색으로 칠해라(=th의 부모인 tr을 색칠함)
				$("#apple").parent().css("background-color", "red");
			});
			
			$("#btn1").click(function(){
				//apple 위에 있는 애들 전체가 적용 범위
				$("#apple").parents().css("background-color", "orange");
			});
			
			$("#btn2").click(function(){
				//table 전까지(tbody까지)의 parents만 찾자!
				$("#apple").parentsUntil("table").css("background-color", "yellow");
			});
			
			$("#btn3").click(function(){
				//tbody 안에 있는 자식 전부
				$("tbody").children().css("background-color", "yellowgreen");
			});
			
			$("#btn4").click(function(){
				//cherry인 곳만 찾아서 색 변경
				$("table").find("td[id=cherry]").css("background-color", "aqua");
			});
			
			$("#btn5").click(function(){
				$("tr, th").css("background-color", "");
				$("tr").parents().css("background-color", "");
			});
			
			$("#btn6").click(function(){
				
				$("tbody > tr").siblings().css("background-color", "darkblue");
			});
			
			$("#btn7").click(function(){
				
				$("#cherry").prev().css("background-color", "violet");
			});
			
			$("#btn8").click(function(){
				
				$("#cherry").next().css("background-color", "pink");
			});
			
			$("tbody > tr").click(function(){
				//클릭한 곳 중심으로 색 다르게 나누기
				$(this).nextAll().css("background-color", "lightgray");
				$(this).prevAll().css("background-color", "coral");
			});
			
		});
		</script>
		
		
<%@ include file="./footer.jsp" %>
