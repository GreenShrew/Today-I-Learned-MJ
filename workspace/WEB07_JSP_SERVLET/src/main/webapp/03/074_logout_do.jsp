<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 074_logout_do.jsp
session.invalidate();	// 현재 세션 아이디에 저장된 세션의 내용을 모두 지운다.
// session.removeAttribute("loginUser"); <-- 이건 세션의 내용 중 해당 이름을 가지는 내용 하나만 지우는 방법이다.
%>
<script type="text/javascript">
alert("로그아웃 되었습니다.");
location.href="071_LoginForm.jsp";
</script>