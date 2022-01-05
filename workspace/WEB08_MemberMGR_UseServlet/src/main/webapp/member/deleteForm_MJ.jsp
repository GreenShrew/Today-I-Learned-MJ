<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 탈퇴</h2>
<form action="withdrawal.do" method="post" name="frm">
	<tr><td>정말로 삭제하시겠습니까?</td></tr>
	<tr><td>
	<input type="submit" value="예">
	<input type="button" value="아니오" onClick="location.href='main.do'">

</form>
</body>
</html>