function loginCheck(){
	if( document.frm.userid.value.length==0){
		alert("아이디를 입력하세요");
		document.frm.userid.focus();
		return false;
	}
	if( document.frm.pwd.value.length==0){
		alert("비밀번호를 입력하세요");
		document.frm.pwd.focus();
		return false;
	}
	return true;
}


function idCheck(){
	if(document.frm.userid.value == ""){
		alert("아이디를 입력해주세요");
		document.frm.userid.focus();
		return;
	}
	var inputid = document.frm.userid.value;
	var opt = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=200";
	window.open("board.do?command=idcheck&userid="+ inputid, "idcheck", opt);
}


function idok(userid){	// 전달인수를 넣어야한다.
	opener.frm.userid.value = userid;
	opener.frm.reid.value = userid;
	self.close;
}



function joinCheck(){
	if(document.frm.userid.value.length==0){
		alert("아이디는 필수입력사항입니다.");
		document.frm.userid.focus();
		return false;
	}
	if(document.frm.userid.value.length<4){
		alert("아이디는 4글자 이상이어야합니다.");
		document.frm.userid.focus();
		return false;
	}
	// 잠시 해결될 때까지 주석처리
//	if(document.frm.userid.value != document.frm.reid.value){
//		alert("아이디 중복체크를 하지 않았습니다..");
//		document.frm.userid.focus();
//		return false;
//	}
	if(document.frm.name.value.length==0){
		alert("이름 필수입력사항입니다.");
		document.frm.name.focus();
		return false;
	}
	if(document.frm.pwd.value==""){
		alert("비밀번호는 반드시 입력해야합니다..");
		document.frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("비밀번호와 확인이 일치하지 않습니다.");
		document.frm.pwd.focus();
		return false;
	}
	return true;
}


function editCheck(){
	if(document.frm.name.value.length==0){
		alert("이름은 필수 입력사항입니다.")
		document.frm.name.focus();
		return false;
	}
	if(document.frm.pwd.value==""){
		alert("비밀번호는 빈드시 입력하여야 합니다.")
		document.frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.")
		document.frm.pwd.focus();
		return false;
	}
	return true;
}
