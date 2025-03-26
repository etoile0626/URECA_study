<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<%@ include file="./nav.jsp" %>
			<!-- 3만큼 마진 -->
		<form class="mt-3" action="/j4param_get.jsp" method="post">
			<div class="input-group"> <!-- span과 text input 필드를 input-group으로 묶음 -->
				<div class="input-group-prepend">
					<span class="input-group-text">NickName</span>
				</div>
				<input type="text" name="nickName">
			</div>

			<br><br>

			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">좋아하는 과일은?</span>
				</div>
				<div class="form-check ml-3">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="fruit" value="apple">apple
					</label>
				</div>
				<div class="form-check ml-3">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="fruit" value="banana">banana
					</label>
				</div>
				<div class="form-check ml-3">
					<label class="form-check-label">
						<input type="checkbox" class="form-check-input" name="fruit" value="cherry">cherry
					</label>
				</div>
			</div>

			<br><br>

			<button class="btn btn-primary" type="submit"> j4param_get으로 전송 </button>
		</form>

<%@ include file="./footer.jsp" %>
    