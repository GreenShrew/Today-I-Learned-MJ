<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
<script type="text/javascript">
	function loginCheck(){	// 아이디와 비밀번호를 공백으로 놔두었는지 체크한다.
		if(document.frm.userid.value == ""){
			alert("아이디를 입력하세요.");
			document.frm.userid.focus();
			return false;
		}
		if(document.frm.pwd.value == ""){
			alert("패스워드를 입력하세요.");
			document.frm.userid.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form action="login.do" method="post" name="frm">	<!-- 이 페이지는 진짜 로그인을 할 예정이므로 LoginServlet의 doPost로 간다. -->
	<table>
		<tr><td>아이디</td><td><input type="text" name="userid"></td></tr>
		<tr><td>암  호</td><td><input type="password" name="pwd"></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="로그인" onClick="return loginCheck()">	<!-- 누르는 순간 위의 스크립트로 넘어간다. -->
			<input type="reset" value="취소">
			<input type="button" value="회원가입" onClick="location.href='join.do'"></td></tr>
			<tr><td colspan="2">${message}</td></tr>
	</table>
</form>
</body>
</html>