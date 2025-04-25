<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>
<%@ include file="../nav.jsp" %>

		<h1>Dong Code</h1>
		<hr>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>시도</th>		<th>구군</th>		<th>동</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<select id="sido" name="sido" class="form-control">
							<option value="0">선 택 하 세 요</option>
						</select>
					</td>
					<td>
						<select id="gugun" name="gugun" class="form-control">
							<option value="0">선 택 하 세 요</option>
						</select>
					</td>
					<td>
						<select id="dong" name="dong" class="form-control">
							<option value="0">선 택 하 세 요</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		<hr>
		<script>
		$(document).ready(function() {
			$.get(	"${pageContext.request.contextPath}/dong-api/sido"
					, function(data, status) {
						$.each(data , function(idx, dto){
							$("#sido").append(
									"<option value='" + dto.code + "'>"
									+ dto.name + "</option>"
							); // append
						}); // each
					} // function
			); // get
		}); // ready
		</script>
		<script>
		$(document).ready(function() {
			$("#sido").change(function() {
				$.get(	"${pageContext.request.contextPath}/dong-api/gugun"
						, {code: $("#sido").val()}
						, function(data, status) {
							$("#gugun").empty();
							$("#gugun").append("<option value='0'>선 택 하 세 요</option>");
							$.each(data , function(idx, dto){
								$("#gugun").append(
										"<option value='" + dto.code + "'>"
										+ dto.name + "</option>"
								); // append
							}); // each
						} // function
				); // get
			}); // change
		}); // ready
		</script>
		<script>
		$(document).ready(function() {
			$("#gugun").change(function() {
				$.get(	"${pageContext.request.contextPath}/dong-api/dong"
						, {code: $("#gugun").val()}
						, function(data, status) {
							$("#dong").empty();
							$("#dong").append("<option value='0'>선 택 하 세 요</option>");
							$.each(data , function(idx, dto){
								$("#dong").append(
										"<option value='" + dto.code + "'>"
										+ dto.name + "</option>"
								); // append
							}); // each
						} // function
				); // get
			}); // change
		}); // ready
		</script>

<%@ include file="../footer.jsp" %>
