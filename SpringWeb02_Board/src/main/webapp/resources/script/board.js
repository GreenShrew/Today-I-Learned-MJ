function loginCheck(){
	if(document.frm.id.value==''){
		alert("아이디를 입력하세요");
		document.frm.id.focus();
		return false;
	}else if(document.frm.pw.value==''){
		alert("비밀번호를 입력하세요");
		document.frm.pw.focus();
		return false;
	}else{
		return true;
	}
}


function idCheck(){
	if(document.frm.id.value==""){
		alert('아이디를 입력해주세요.');
		document.frm.id.focus();
		return false;
	}
	var id = document.frm.id.value;
	var opt = "toolbar=no, menubar=no, resizable=no, width=450, height=200";
	window.open("idcheck?id=" + id, "중복체크", opt);
	// 리퀘스트에도 ? 와 함께 기존처럼 파라미터를 붙여서 링크를 만들 수 있다.
}


function idok(userid){
	opener.frm.id.value = userid;
	opener.frm.re_id.value = userid;
	self.close();
}


function joinCheck(){
	if(document.frm.id.value==""){
		alert('아이디를 입력해주세요.');
		document.frm.id.focus();
		return false;
	}else if(document.frm.name.value.length==0){
		alert('이름을 입력해주세요.');
		document.frm.name.focus();
		return false;
	}else if(document.frm.pw.value==""){
		alert('비밀번호를 입력해주세요.');
		document.frm.pw.focus();
		return false;
	}else if(document.frm.pw.value != document.frm.pw_check.value){
		alert('비밀번호가 일치하지 않습니다');
		document.frm.pw_check.focus();
		return false;
	}else if(document.frm.id.value != document.frm.re_id.value){
		alert('아이디 중복체크를 하지 않았습니다.');
		document.frm.id.focus();
		return false;
	}else if(document.frm.phone.value==""){
		alert('전화번호를 입력해주세요.');
		document.frm.phone.focus();
		return false;
	}else{
		return true;
	}
}


function editCheck(){
	if(document.frm.name.value.length==0){
		alert('이름을 입력해주세요.');
		document.frm.name.focus();
		return false;
	}else if(document.frm.pw.value==""){
		alert('비밀번호를 입력해주세요.');
		document.frm.pw.focus();
		return false;
	}else if(document.frm.pw.value != document.frm.pw_check.value){
		alert('비밀번호가 일치하지 않습니다');
		document.frm.pw_check.focus();
		return false;
	}else if(document.frm.phone.value==""){
		alert('전화번호를 입력해주세요.');
		document.frm.phone.focus();
		return false;
	}else{
		return true;
	}
}


function boardCheck(){
	if(document.frm.pass.value==''){
		alert('비밀번호를 입력해주세요.');
		document.frm.pass.focus();
		return false;
	}else if(document.frm.title.value==''){
		alert('제목을 입력해주세요.');
		document.frm.title.focus();
		return false;
	}else if(document.frm.content.value==''){
		alert('내용을 입력해주세요.');
		document.frm.content.focus();
		return false;
	}else{
		return true;
	}
}


function reply_check(){
	if(document.frm2.reply==''){
		alert('댓글을 입력해주세요.');
		document.frm2.reply.focus();
		return false;
	}else{
		return true;
	}
}