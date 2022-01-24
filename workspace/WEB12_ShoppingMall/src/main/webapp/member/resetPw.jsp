<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/shopping.css" rel="stylesheet">
<script type="text/javascript">
function resetPw{
	if(doucment.frm.pwd.value==""){
		alert("비밀번호를 입력하세요.");
		document.frm.pwd.focus();
		return false;
	}
	if(doucment.frm.pwd.value!=document.frm.pwd_chk.value){
		alert("비밀번호 확인이 일치하지 않습니다.");
		document.frm.pwd_chk.focus();
		return false;
	}
}
</script>
</head>
<body>
<h2>비밀번호 재설정</h2>
<form method="post" name="frm" action="shop.do">
<input type="hidden" name="command" value="resetPw">
<input type="hidden" name="id" value="${id}">
	<table align="center" bgcolor="black" cellspacing="1" width="400">
		<tr align="center" bgcolor="#FDE8FF"><td width="430"><h3>비밀번호<input type="password" name="pwd"></h3></td></tr>
		<tr align="center" bgcolor="#FDE8FF"><td width="430"><h3>비밀번호확인<input type="password" name="pwd_chk"></h3></td></tr>
		<tr align="center" bgcolor="#FDE8FF"><td width="430">
	</table>
</form>
</body>
</html>