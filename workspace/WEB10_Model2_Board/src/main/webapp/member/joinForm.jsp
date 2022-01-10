<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/script.js"></script>
</head>
<body>
<h1>사용자 등록</h1>
<div id="wrap" align="center">
<form name="frm" method="post" action="board.do">
<input type="hidden" name="command" value="join">
<table>
	<tr><th>아이디</th><td><input type="text" name="userid" size="20"> *
		<input type="button" value="중복체크" onClick="idCheck();">
		<input type="hidden" name="reid"></td></tr>
	<tr><th>이름</th><td><input type="text" size="20" name="name"> *</td></tr>
	<tr><th>비밀번호</th><td><input type="password" size="20" name="pwd"> *</td></tr>
	<tr><th>비밀번호 확인</th><td><input type="password" size="20" name="pwd_check"> *</td></tr>
	<tr><th>이메일</th><td><input type="text" size="20" name="email"></td></tr>
	<tr><th>전화번호</th><td><input type="text" size="20" name="phone"></td></tr>
	<tr><th>등급</th><td><input type="radio" value="0" name="admin" checked="checked">
		일반회원 <input type="radio" name="admin" value="1"> 관리자</td></tr>
</table><br><br>
<input type="submit" value="등록" onClick="return joinCheck();">
<input type="reset" value="다시 작성"><input type="button" value="로그인페이지로" onClick="location.href='board.do?command=loginForm'">

</form>
</div>
</body>
</html>