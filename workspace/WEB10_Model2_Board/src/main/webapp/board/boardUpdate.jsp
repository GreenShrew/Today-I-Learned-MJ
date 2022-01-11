<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdate</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script src="script/script.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>게시글 수정</h1>
<form name="frm" method="post" action="board.do?command=boardUpdate">
<input type="hidden" name="num" value="${board.num}">
<table>
	<tr><th>작성자</th><td>${board.userid}
	<input type="hidden" name="userid" value="${loginUser.userid}"></td></tr>
	<tr><th>비밀번호</th><td>
	<input type="password" name="pass" size="12">* (게시물 수정 삭제시 필요합니다.)</td></tr>
	<tr><th>이메일</th><td>
	<input type="text" name="email" value="${board.email}" size="12"></td></tr>
	<tr><th>제목</th><td>
		<input type="text" name="title" value="${board.title}" size="20">*</td></tr>
	<tr><th>내용</th><td>
		<textarea cols="70" rows="15" name="content">${board.content}</textarea>*</td></tr>
</table><br>
<input type="submit" value="수정" onclick="return boardCheck()">
<input type="reset" value="다시작성">
<input type="button" value="돌아가기" 
	onclick="location.href='board.do?command=boardViewWithoutCount&num=${board.num}'">
</form>
</div>
</body>
</html>