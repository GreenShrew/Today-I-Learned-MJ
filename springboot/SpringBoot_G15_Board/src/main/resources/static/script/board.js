function idCheck(){
	if( document.frm.userid.value==""){
		alert('아이디를 입력하여 주십시오.');
		document.frm.userid.focus();
		return;
	}
	var k = document.frm.userid.value
	var opt = "toolbar=no,menubar=no,resizable=no,width=450,height=200";
	window.open("idcheck?userid=" + k, "id check", opt);
} 


function idok(userid){
	opener.frm.userid.value = userid;
	opener.frm.re_id.value = userid;
	self.close();
}



function selectimg(){
	var opt = "toolbar=no,menubar=no,resizable=no,width=450,height=200";
	window.open( 'selectimg' , 'selectimg',  opt);
}


function selectedimage(){
	document.frm.submit();
}





function reply_check(){
	if(document.frm2.content.value.length==0){
		alert("댓글을 입력해주세요");
		frm2.content.focus();
		return false;
	}else{
		return true;
	}
}
