<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html" %>
<%@ include file="sub_menu.html" %>
<article>
<h2>Edit Profile</h2>
<!-- 회원가입 폼과 같이 주소 검색시 결과를 받기위해 Form 이름을 updateForm이 아니라 joinForm으로 한다. -->
<form method="post" name="joinForm">
<input type="hidden" name="command" value="memberUpdate"/>
	<fieldset>
		<legend>Basic Info</legend>
		<!-- id는 수정대상이 아니면서, submit 할때 전송될 대상이므로, input type="text"로 하되 readonly로 설정해서 수정을 금지시킨다. -->
		<label>User ID</label><input type="text" name="id" value="${loginUser.id}" readonly><br>
		<label>Password</label><input type="password" name="pwd"><br>
		<label>Retype Password</label><input type="password" name="pwdCheck"><br>
		<label>Name</label><input type="text" name="name" value="${loginUser.name}"><br>
		<label>E-Mail</label><input type="text" name="email" value="${loginUser.email}">
	</fieldset>
	<fieldset>
		<legend>Optional</legend>
		<label>Zip Code</label><input type="text" name="zip_num" size="10" value="${loginUser.zip_num}">
			<input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
		<label>Address</label><input type="text" name="addr1" size="50" value="${addr1}"><br><!-- EditFormAction에서 넘어온 값 -->
		<label>&nbsp;</label><input type="text" name="addr2" size="25" value="${addr2}"><br>
		<label>Phone Number</label><input type="text" name="phone" value="${loginUser.phone}"><br>	
	</fieldset><div class="clear"></div>
	<div id="buttons"><input type="button" value="정보 수정" class="submit" onclick="go_update();">
	<input type="reset" value="취소" class="cancel"></div>
</form>
</article>
<%@ include file="../footer.jsp" %>