
function loginCheck(){
	if(document.loginFrm.id.value==""){
		alert("아이디는 필수 입력 사항입니다.");
		document.loginFrm.id.focus();
		return false;
	}
	if(document.loginFrm.pwd.value==""){
		alert("비밀번호는 필수 입력 사항입니다.");
		document.loginFrm.pwd.focus();
		return false;
	}
	return true;
}