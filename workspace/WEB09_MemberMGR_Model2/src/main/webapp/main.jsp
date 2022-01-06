<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<table>
	<tr><td>안녕하세요. ${loginUser.name}(${loginUser.userid})님</td></tr>
	<tr><td> email : ${loginUser.email}</td></tr>
	<tr><td> 전화번호 : ${loginUser.phone}</td></tr>
	<tr>
		<td>
			<input type="button" value="로그아웃" onclick="location.href='member.do?command=logout'">
			<input type="button" value="회원정보변경" onclick="location.href='member.do?command=updateForm'">
			<input type="button" value="회원탈퇴" onclick="location.href='member.do?command=deleteMember'">
		</td>
	</tr>
</table>
</body>
</html>