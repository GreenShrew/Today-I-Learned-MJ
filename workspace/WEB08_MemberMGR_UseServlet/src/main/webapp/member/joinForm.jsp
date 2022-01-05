<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
<script type="text/javascript">
	function idCheck(){
		if(document.frm.userid.value.legnth == 0){	// 만약 아이디창에 아무것도 안 쓰고 중복체크를 누르면 실행
			alert("중복조회할 아이디를 먼저 입력하고 버튼을 눌러주세요.")
			document.frm.userid.focus();	// 커서가 아이디창에 깜빡이도록 만듦
			return;
		}
		
		var inputid = document.frm.userid.value;	// 매번 쓰기에는 길어서 변수에 저장하고 사용
		var opt = "toolbar=no, menubar=no, scrollbars=yes, resizable=not, width=500, height=200";
		window.open("idcheck.do?userid=" + inputid, "idcheck", opt);	// (url, 팝업창의 이름, 옵션)
		// 팝업창 오픈 메뉴의 idcheck.do는 서블릿이며, 서블릿에서 아이디 중복체크 작업을 한 후, 결과를 싣고 포워딩되는 데이터를 페이지 팝업창에 표시할 예정이다.
		// 서블릿 호출시 파라미터를 위와 같이 호출되는 주소에 ?와 함께 전달할 수 있다.
	}
	
	function joinCheck(){
		if(document.frm.name.value == ""){	// 이름이 빈칸이라면 
			alert("이름은 필수 입력사항입니다.");
			document.frm.name.focus();
			return false;
		}
		if(document.frm.userid.value.length == 0){		// 아이디가 빈칸이라면, 위와같이 쓸 수 있지만, 길이가 0인것도 빈칸이다! 
			alert("아이디는 필수 입력사항입니다.");
			document.frm.userid.focus();
			return false;
		}
//		if(document.frm.userid.value != document.frm.reid.value){	// 아이디 중복체크 했는지 여부!
//			alert("아이디 중복체크를 하지 않으셨습니다.");
//			document.frm.userid.focus();
//			return false;
//		}
		if(document.frm.pwd.value.length == 0){	// 비밀번호가 빈칸이라면
			alert("비밀번호는 필수 입력사항입니다.");
			document.frm.pwd.focus();
			return false;
		}
		if(document.frm.pwd.value != document.frm.pwd_check.value){	// 작성한 비밀번호와 비밀번호확인 란이 같은지 여부
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			document.frm.pwd_check.focus();
			return false;
		}
		return true;		// 모든 if문을 통과하면 회원가입 완료!
	}
</script>
</head>
<body>
<h2>회원 가입</h2>
'*' 표시 항목은 필수 입력 항목입니다.
<form action="join.do" method="post" name="frm">
<table>
	<tr><td>이름</td><td><input type="text" name="name" size="20">&nbsp;*</td></tr>
	<tr><td>아이디</td><td><input type="text" name="userid" size="20">&nbsp;*
		<input type="button" value="중복 체크" onclick="idCheck();"/>
		<input type="hidden" name="reid" value="">	<!-- idcheck.jsp에서 idok()로 넘어온  -->
		</td></tr>
	<tr><td>비밀번호</td><td><input type="password" name="pwd" size="20">&nbsp;*</td></tr>
	<tr><td>비밀번호 확인</td><td><input type="password" name="pwd_check" size="20">&nbsp;*</td></tr>
	<tr><td>이메일</td><td><input type="text" name="email" size="20"></td></tr>
	<tr><td>전화번호</td><td><input type="text" name="phone" size="20"></td></tr>
	<tr><td>등급</td><td><input type="radio" name="admin" value="0" checked="checked">
		일반회원&nbsp;<input type="radio" name="admin" value="1">관리자</td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="회원 가입" onClick="return joinCheck()"/>
		<input type="reset" value="취소"></td></tr>
</table>
</form>

</body>
</html>