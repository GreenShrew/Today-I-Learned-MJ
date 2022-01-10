<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${empty loginUser}">
	<jsp:forward page='board.do?command=loginForm' />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
</head>
<body>
<div id="wrap" align="center">

<h1>게시글 리스트</h1>
<table>
	<tr>
		<td colspan="5" style="border:white;">
			<div style="float:left;">${loginUser.name}(${loginUser.userid})님 로그인 
			<input type="button" value="회원정보수정" 
				onClick="location.href='board.do?command=editMemberForm'"/>
			<input type="button" value="로그아웃"
				onClick="location.href='board.do?command=logout'"></div>
			<div style="float:right;">
				<a href="board.do?command=boardWriteForm">게시글 등록</a>
			</div>
		</td>
	</tr>
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회</th></tr>
	<c:forEach items="${boardList}" var="board">
		<tr   align="center">
			<td>${board.num}</td>
			<td  align="left">${board.title}</td>
			<td>${board.userid}</td>
			<td>${board.writedate}</td>
			<td>${board.readcount}</td>
		</tr>
	</c:forEach>

</table>

</div>
</body>
</html>




