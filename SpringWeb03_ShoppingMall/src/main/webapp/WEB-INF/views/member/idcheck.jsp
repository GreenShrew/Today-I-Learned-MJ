<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idcheck</title>
<link href="resources/css/shopping.css" rel="stylesheet">
<script type="text/javascript">
	function idok(userid){
		opener.formm.userid.value=userid;
		opener.formm.reid.value=userid;
		self.close();
	}
</script>
</head>
<body>
<div id="wrap">
<h1>ID 중복확인</h1>
<form method="post" name="formm" action="idCheckForm">
	<input type="hidden" name="command" value="idCheckForm"><!-- 아이디를 다시 검색할 수 있는 기능 -->
	User ID : <input type="text" name="userid" value="${userid}">	<!-- 건너온 id를 한번 다시 보여준다. -->
	<input type="submit" value="검색" class="submit"><br>
	
	<div style="margin-top:20px">
		<c:if test="${result == 1}">
			<script type="text/javascript">opener.document.formm.userid.value="";</script>
			${userid}는 이미 사용중인 아이디입니다.
		</c:if>
		<c:if test="${result == -1}">
			${userid}는 사용 가능한 아이디입니다.
			<input type="button" value="사용" class="cancel" onclick="idok('${userid}');">
		</c:if>
	</div>
</form>
</div>
</body>
</html>