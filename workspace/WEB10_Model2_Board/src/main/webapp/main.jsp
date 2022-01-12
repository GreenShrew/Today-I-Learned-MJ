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
			<td width="100">${board.num}</td>
			<td align="left">&nbsp;&nbsp;
				<a href="board.do?command=boardView&num=${board.num}">${board.title}</a>
				<c:if test="${board.replycnt>0}">		<!-- 댓글이 있다면... -->
					<span style="color:red; font-weight:bold;">[${board.replycnt}]</span>
				</c:if>
				<!-- boardview로 넘어갈 때 누른 게시물의 번호를 같이 보낸다. 이 번호를 이용해 DB의 내용 하나를 긁어올 수 있도록 만든다. -->
			</td>
			<td width="100">${board.userid}</td>
			<td width="200">${board.writedate}</td>
			<td width="100">${board.readcount}</td>
		</tr>
	</c:forEach>
</table><br><br>

<!-- 여기서부터 페이지 표시 -->
<div id="paging" align="center" style="font-size:110%; font-weight:bold;">
	<!-- 페이지가 클릭될때마다 이동할 링크 기본경로를 변수에 저장 --> 
	<c:url var="action" value="board.do?command=main"/>
	<c:if test="${paging.prev}">
		<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
		<!-- 링크되는 주소 -> board.do?command=main&page=? -->
		<!-- 맨 왼쪽 페이지(beginPage)보다 1페이지 더 작은 페이지로 이동 -->
	</c:if>
	
	<!-- 실제 페이지들의 표시 - 반복문 사용(beginPage부터 endPage까지) -->
	<!-- index라는 변수를 만들어서 이를 beginPage부터 endPage까지 반복한다. -->
	<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
		<c:choose>
			<c:when test="${paging.page==index}">		<!-- 현재 보고있는 페이지와 index값이 같다면 -->
				<span style="color:red">${index}&nbsp;</span>		<!-- 글자색을 빨갛게 만들고 링크는 x -->
			</c:when>
			<c:otherwise>
				<!-- 아래 action은 위에 변수명이 action인 url 태그의 value이다. -->
				<a href="${action}&page=${index}">${index}</a>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${paging.next}">
		<a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
		<!-- 맨 오른쪽 페이지(endPage)보다 1페이지 더 작은 페이지로 이동 -->
	</c:if>
</div>
</body>
</html>




