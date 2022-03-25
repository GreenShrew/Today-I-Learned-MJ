<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminLoginForm</title>
<link  rel="stylesheet" href="/admin/admin.css">
<script type="text/javascript">
function worker_check(){
	if(document.frm.workId.value==""){
		alert("아이디를 입력하세요");
		return false;
	} 
	if(document.frm.workPwd.value==""){
		alert("패스워드를 입력하세요");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div id="wrap">
	<header><div id="logo"><a href="admin">
		<img src="/admin/bar_01.gif"  style="float:left;"><img src="/admin/text.gif" ></a></div>
	</header><div class="clear"></div>
	<article>
	<div id="loginform">
		<form name="frm" method="post" action="adminLogin">
		<table>
			<tr><td>아 이 디</td><td><input type="text" name="workId" size="10"></td></tr>
			<tr><td>비밀번호</td><td><input type="password" name="workPwd" size="10"></td></tr>
       		<tr align="center" ><td  colspan="2">
       			<input class="btn" type="submit" value="업무 로그인" onClick="return worker_check();"><br><br>
       			<h4 style="color:red">${message}</h4></td></tr>
		</table>
		</form>
	</div></article>
</div>
</body>
</html>