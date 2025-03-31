<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>jq12</h1>
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
			</tbody>
		</table>

		<script>
		$(document).ready(function(){
			
			//$("tr").hover(infuntion, outfuntion) tr에 hover를 하면 2개의 함수를 가져야함
			$("tr").hover(				//마우스 진입 여부에 따른 함수처리 = hover?
					function(){			//마우스가 진입할때
						$("tr:even").css("background-color", "aqua");
						$("tr:odd").css("background-color", "coral");
					}
					, function(){		//마우스가 나갈때
						$("tr:even").css("background-color", "coral");
						$("tr:odd").css("background-color", "aqua");
					}
				);
		});
		</script>
		
		
<%@ include file="./footer.jsp" %>
