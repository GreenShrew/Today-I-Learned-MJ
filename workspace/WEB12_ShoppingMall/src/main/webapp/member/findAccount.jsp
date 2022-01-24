<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findAccount</title>
<link href="css/shopping.css" rel="stylesheet">
</head>
<body>
<center><h2>아이디 찾기 / 비밀번호 찾기</h2></center>
<form>
<table align="center" bgcolor="black" cellspacing="1" width="400">
	<tr align="center" bgcolor="#FDE8FF" height="200">
		<td width="230"><h3>아이디 찾기</h3><br>
			<input type="button" class="submit" value="이동" onClick="location.href='shop.do?command=findIdForm'">
		</td>
		<td width="230"><h3>비밀번호 찾기</h3><br>
			<input type="button" class="submit" value="이동" onClick="location.href='shop.do?command=findPwdForm'">
		</td>
	</tr>
</table>
</form>
</body>
</html>