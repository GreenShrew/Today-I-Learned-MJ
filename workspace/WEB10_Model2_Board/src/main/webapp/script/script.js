function loginCheck(){
	if(document.frm.userid.value.length==0){
		alert("아이디를 입력하세요");
		document.frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value.length==0){
		alert("비밀번호를 입력하세요");
		document.frm.pwd.focus();
		return false;
	}
	return true;
}