<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>

		<h1>j5scriptlet = 스크립트가 뿔뿔히 조각난 것을 이야기 함 (아래 참고)</h1>
			<!-- class 준거는 boot strap 적용한 것 -->
		<h3 class="text-center">실습 : 99단 만들기 </h3>
		<table class="table table-hober">
			<%for (int dan = 1; dan <=9; dan++){ %>
				<tr>
					<%for(int gop = 1; gop <=9; gop++){  %>
						<td> 
							<%= dan %> * <%= gop %> = <%= dan * gop %>
						</td>
					<% } %>
				</tr>
			<% } %>
		</table>

<%@ include file="./footer.jsp" %>
