<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idcheck</title>
<script type="text/javascript">
	function idok(){
		<!-- request에 저장되어있는 userid를 opener.document.frm.userid.value와 opener.document.frm.userid.value
		에 넣는다. -->
		document.frm.userid.value="${userid}";
		document.frm.reid.value="${userid}";		// EL 문법이 자바스크립트에서도 쓰일 수 있다.
		self.close();
	}
</script>
</head>
<body>
<br>
<form action="idcheck.do" method="get" name="frm">	<!-- 아이디가 중복되면 또다른 아이디를 체크할 수 있도록 다시 검색할 수 있도록 만듦 -->
	아이디 : <input type="text" name="userid" value="${userid}">
	<input type="submit" value="중복 체크">
</form>
<br><br>

<c:if test="${result==1}">
	${userid}는 이미 사용중인 아이디입니다.
	<script type="text/javascript">
		opener.document.frm.userid.value="";	// 팝업창을 오픈한 주체 : opener
	</script>
</c:if>
<c:if test="${result==-1}">
	${userid}는 사용 가능한 아이디입니다.
	<input type="button" value="사용" onClick="idok();">
</c:if>
</body>
</html>