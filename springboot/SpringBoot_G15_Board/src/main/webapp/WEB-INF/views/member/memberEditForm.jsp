<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/board.css"/>
<script src="/script/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>사용자 수정</h1>
<form name="frm" method="post" action="memberEdit">
<table>
	<tr><th>아이디<td>${dto.userid}
		<input type="hidden" name="userid" value="${dto.userid}"></td></tr>
	<tr><th>암호<td><input type="password" name="pwd" size="20"> * </td></tr>
	<tr><th>암호 확인<td><input type="password" name="pwd_check" size="20"> * </td></tr>
	<tr><th>이름<td><input type="text" name="name" size="20" value="${dto.name}"> * </td></tr>
	<tr><th>전화번호<td><input type="text" name="phone" size="20" value="${dto.phone}"></td></tr>
	<tr><th>이메일<td><input type="text" name="email" size="20" value="${dto.email}"></td></tr>
</table><br><br>
	<input type="submit" value="수정">
	<input type="reset" value="다시 작성">
	<input type="button" value="목록으로" onClick="location.href='main'">
	${message}
</form>
</div>
</body>
</html>