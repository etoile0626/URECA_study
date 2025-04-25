<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>
<%@ include file="../nav.jsp" %>

		<h1>Dong Search</h1>
		<hr>
		<input type="text" class="form-control" id="txtSearch" name="txtSearch">
		<div id="resultDiv"></div>
		<hr>
		<script>
		$(document).ready(function() {
			$("#txtSearch").keyup(function() {
				$.get(	"${pageContext.request.contextPath}/dong-api/search"
						, {name: $("#txtSearch").val()}
						, function(data, status) {
							$("#resultDiv").empty();
							$.each(data , function(idx, dto){
								$("#resultDiv").append(
										"<h5 class='toWindow'>" + dto.name + "</h5>"
								); // append
								$(".toWindow").on("click", function() {
									$("#txtSearch").val( $(this).text() );
								}); // on
							}); // each
						} // function
				); // get
			}); // change
		}); // ready
		</script>

<%@ include file="../footer.jsp" %>
