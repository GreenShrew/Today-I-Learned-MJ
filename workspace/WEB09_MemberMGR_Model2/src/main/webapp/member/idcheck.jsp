<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idcheck</title>
<script type="text/javascript">
function idok(userid){
	opener.frm.userid.value = userid;
	opener.frm.reid.value = userid;
	self.close();
}
</script>
</head>
<body>
<form action="member.do" name="frm">	<!-- 아이디 중복 체크 재검색 창 -->
	<input type="hidden" name="command" value="idcheck">
	아이디 <input type="text" name="userid" value="${userid}">
			<input type="submit" value="중복 체크">
</form><br><br><br><br>

<c:if test="${result==1}">
	<script type="text/javascript">
		opener.document.frm.userid.value = "";
	</script>
	${userid}는 이미 사용중인 아이디입니다.
</c:if>
<c:if test="${result==-1}">
	${userid}는 사용 가능한 아이디입니다.
		<input type="button" value="사용" class="cancel" onclick="idok('${userid}')">
</c:if>
</body>
</html>