<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq17</h1>
		<hr>
		
		<div id="div1"> </div>
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

		
		

		<script>
		$(document).ready(function(){
		
			$("td").click(function(){
				$("#div1").empty();
				$("#div1").append("<h2>this.text : "+$(this).text()+"</h2>");		//td
				$("#div1").append("<h2>this.parent.text : "+$(this).parent().text()+"</h2>");	//tr
				$("#div1").append("<h2>this.parent.parent.text : "					
						+$(this).parent().parent().text()+"</h2>");		//tbody			
				$("#div1").append("<h2>this.parent.parent.parent.text : "
						+$(this).parent().parent().parent().text()+"</h2>");	//table
				$("#div1").append("<h2>this.parent.parent.parent.children.first.text : "
						+$(this).parent().parent().parent().children().first().text()+"</h2>"); //thead
				$("#div1").append("<h2>this.parent.parent.parent.text : "
						+$(this).parent().parent().children.eq(1).children.eq(1).text()+"</h2>");//banana
			});
			
		});
		</script>
		
		
<%@ include file="./footer.jsp" %>
