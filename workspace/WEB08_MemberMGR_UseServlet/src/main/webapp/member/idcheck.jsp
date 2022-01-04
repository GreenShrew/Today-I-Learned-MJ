<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idcheck</title>
</head>
<body>
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