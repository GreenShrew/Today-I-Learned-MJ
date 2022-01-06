<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
<script type="text/javascript">
function idCheck(){
	if(document.frm.user.value.length==0){
		alert("아이디를 입력해주세요");
		document.frm.userid.focus();
		return
	}
	
	var inputid = document.frm.userid.value;
	var opt = "toolbar=no, menubar=no, scrollbars=yes, resizeable=no, width=500, height=200";
	window.open("member.do?command=idcheck&userid="+inputid, "idcheck", opt);
}

function joinCheck(){
	if(document.frm.name.value.length==0){
		alert("이름은 필수 입력사항입니다.");
		document.frm.name.focus();
		return false;
	}
	if(document.frm.userid.value.length==0){
		alert("아이디는 필수 입력사항입니다.");
		document.frm.userid.focus();
		return false;
	}
/*	if(document.frm.userid.value != document.frm.reid.value){
		alert("아이디 중복체크를 하지 않으셨습니다.");
		document.frm.userid.focus();
		return false;
	}*/
	if(document.frm.pwd.value.length==0){
		alert("비밀번호는 필수 입력사항입니다.");
		document.frm.pwd.focus();
		return false;
	}

	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("비밀번호는 확인이 일치하지 않습니다.");
		document.frm.pwd_check.focus();
		return false;
	}
}
</script>
</head>
<body>
<h2>회원 가입</h2>
'*' 표시 항목은 필수입니다.
<form action="member.do" method="post" name="frm">
<input type="hidden" name="command" value="join">
<table>
	<tr><td>이름</td><td><input type="text" name="name" size="20">&nbsp;*</td></tr>
	<tr><td>아이디</td><td><input type="text" name="userid" size="20">&nbsp;*
		<input type="button" value="중복 체크" onClick="idCheck();"/>
		<input type="hidden" name="reid" value=""></td></tr>
	<tr><td>비밀번호</td><td><input type="password" name="pwd" size="20">&nbsp;*</td></tr>
	<tr><td>비밀번호 확인</td><td><input type="password" name="pwd_check" size="20">&nbsp;*</td></tr>
	<tr><td>이메일</td><td><input type="text" name="email" size="20"></td></tr>
	<tr><td>전화번호</td><td><input type="text" name="phone" size="20"></td></tr>
	<tr><td>등급</td><td><input type="radio" name="admin" value="0" checked="checked">
		일반회원&nbsp;<input type="radio" name="admin" value="1">&nbsp;관리자</td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="회원 가입" onClick="return joinCheck();"/>
		<input type="reset" value="취소"/>
	</td></tr>
</table>
</form>
</body>
</html>