function loginCheck(){
	if(document.loginFrm.id.value==""){
		alert("아이디는 필수입력사항입니다");
		document.loginFrm.id.focus();
		return false;
	}
	if(document.loginFrm.pwd.value==""){
		alert("비밀번호는 필수입력사항입니다");
		document.loginFrm.pwd.focus();
		return false;
	}
	return true;
}


function go_next(){
	// 자바스크립트에서 jsp 페이지 내의 radio 버튼을 바라볼때, 같은 name의 okin 인것이 여러개라면 name  값에 의한 배열로 인식되어 사용됩니다.   
	// 동의함 버튼 : okon[0],  동의안함  버튼 : okon[1]  
	if( document.formm.okon[1].checked == true ){ 
	 	/* 동의 안함 버튼이 선택된 상태  */
		alert("회원약관에 동의하셔야 회원으로 가입이 가능합니다");
	} else {
		// frmm 폼에  action 도 없고 submit 버튼도 없는 것을 스크립트 명령으로 설정하고 submit 까지 실행합니다 
		document.formm.action = "joinForm";
		document.formm.submit();
	}
}


function idcheck(){
	if( document.formm.userid.value=="" ){
		alert("아이디를 입력하고 중복체크를 진행하세요" );
		documnet.formm.userid.focus();
		return;
	}
	var url = "idCheckForm?userid=" + document.formm.userid.value;
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250, scrollbars=no";
	window.open(url, "IdCheck", opt);	
}




function post_zip(){
	var url = "findZipNum";
	var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=550,";
	opt = opt + " height=300, top=300, left=300";
	window.open( url, "우편번호 찾기", opt );
}



function go_save(){
	if (document.formm.userid.value == "") {
		alert("아이디를 입력하여 주세요."); 	    
	    document.formm.userid.focus();
	} else if(document.formm.reid.value != document.formm.userid.value){
		alert("아이디 중복확인을 하지 않았습니다");		
		document.formm.userid.focus();
	} else if(document.formm.pwd.value == "") {
	    alert("비밀번호를 입력해 주세요.");	    
	    document.formm.pwd.focus();
	} else if(document.formm.pwd.value != document.formm.pwdCheck.value) {
	    alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");	    
	    document.formm.pwd.focus();
	} else if(document.formm.name.value == "") {
	    alert("이름을 입력해 주세요.");	    
	    document.formm.name.focus();
	} else if(document.formm.email.value == "") {
	    alert("이메일을 입력해 주세요.");	   
	    document.formm.email.focus();
	} else{
		document.formm.action = "join";
	    document.formm.submit();
	}
}




function go_update(){
	if (document.formm.pwd.value == "") {
	    alert("비밀번호를 입력해 주세요.");
	    document.formm.pwd.focus();
	}else if ((document.formm.pwd.value != document.formm.pwdCheck.value)) {
	    alert("비밀번호가 일치하지 않습니다.");
	    document.formm.pwd.focus();
	}else if (document.formm.name.value == "") {
	    alert("이름을 입력해 주세요.");
	    document.formm.name.focus();
	} else if (document.formm.email.value == "") {
	    alert("이메일을 입력해 주세요.");
	    document.formm.email.focus();
	}else {
	    document.formm.action = "memberUpdate";
	    document.formm.submit();
	}
}




function find_account(){

	var url = "shop.do?command=findAccount";
	var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=700,";
	opt = opt + "height=500, top=300, left=300";
	window.open(url, "Find Id/Pw", opt);
	
}















