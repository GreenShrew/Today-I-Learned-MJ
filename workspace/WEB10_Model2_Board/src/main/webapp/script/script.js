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
	if(document.frm.userid.value != document.frm.reid.value){
		alert("아이디 중복체크를 하지 않았습니다..");
		document.frm.userid.focus();
		return false;
	}
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
	if( document.frm.name.value.length==0){
		alert("이름은 필수입력사항입니다");		
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



function boardCheck(){
	if(document.frm.pass.value==""){
		alert("비밀번호는 수정/삭제시에 필요합니다.");
		document.frm.pass.focus();
		return false;
	}
	if(document.frm.title.value==""){
		alert("제목은 필수사항입니다.");
		document.frm.title.focus();
		return false;
	}
	if(document.frm.content.value==""){
		alert("내용을 입력해주세요.");
		document.frm.content.focus();
		return false;
	}
	return true;
}


function open_win(num, name){		// 수정, 삭제용 팝업창 명령
	var url = "board.do?command=boardPassForm&num="+num;	// 패스워드를 입력받는 form
	var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, witdh=500, height=300";
	window.open(url, name, opt);
}

function passCheck(){
	if(document.frm.pass.value.length==0){
		alert("비밀번호를 입력하세요");
		document.frm.pass.focus();
		return false;
	}
	return true;
}




function reply_check(){
	if(document.frm_reply.reply.value==""){
		alert("댓글 내용을 입력하세요");
		document.frm_reply.reply.focus();
		return false;
	}
	return true;
}