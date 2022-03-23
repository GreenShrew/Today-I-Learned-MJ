<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link  rel="stylesheet" href="/css/shopping.css">
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
	User ID <input type=text name="userid" value="${userid}">
	<input type=submit value="검색" class="submit"><br>     
	<div style="margin-top: 20px">
		<c:if test="${result == 1}">
			<script type="text/javascript">opener.document.formm.userid.value="";</script>
			${userid}는 이미 사용중인 아이디입니다.
		</c:if>
		<c:if test="${result==-1}">
			${userid}는 사용 가능한 ID입니다.    
			<input type="button" value="사용" class="cancel"	onclick="idok('${userid}')">
		</c:if>
	</div>
</form>
</div>
</body>
</html>