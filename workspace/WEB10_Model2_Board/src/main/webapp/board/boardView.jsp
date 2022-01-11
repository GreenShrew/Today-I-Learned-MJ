<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${empty loginUser}">
	<jsp:forward page='board.do?command=index'/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardView</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script src="script/script.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>게시글 상세보기</h1>
<table>
	<tr><th>작성자</th><td>${board.userid}</td>
		<th>이메일</th><td>${board.email}</td></tr>
	<tr><th>작성일</th><td><fmt:formatDate value="${board.writedate}"/></td>
		<th>조회수</th><td>${board.readcount}</td></tr>
	<tr><th>제목</th><td colspan="3">${board.title}</td></tr>
	<tr><th>내용</th><td colspan="3"><pre>${board.content}</pre></td></tr>
</table><br><br>
<input type="button" value="리스트" onClick="location.href='board.do?command=main'">
<input type="button" value="수정" onClick="open_win('${board.num}', 'update');">
<input type="button" value="삭제" onClick="open_win('${board.num}', 'delete');">

<br><br><!-- 여기서부터 댓글 작성 영역 -->
<c:set var="now" value="<%=new java.util.Date() %>"></c:set>	<!-- 화면에 표시할 현재시각 -->
<form action="board.do" method="post" name="frm_reply">	<!-- 위에 frm이라는 form 태그와 겹치면 안된다. -->
	<input type="hidden" name="command" value="addReply">
	<input type="hidden" name="boardnum" value="${board.num}">
	<table>
		<tr>
			<th width="100">작성자</th>
			<th width="100">작성일지</th>
			<th>내용</th>
			<th width="100">추가/삭제</th>
		</tr>
		<tr align="center">
			<td>${loginUser.userid}
				<input type="hidden" name="userid" value="${loginUser.userid}"></td>
			<td><fmt:formatDate value="${now}" pattern="MM/dd HH:mm"/></td>
			<td><input type="text" name="reply" size="80"></td>
			<td><input type="submit" value="답글작성" onclick="return reply_check();"></td>
		</tr><!-- 작성자, 날짜시간, 작성란, 버튼 제작! -->
		
		<!-- 달린 댓글이 출력되는 공간 -->
		<c:forEach items="${replyList}" var="reply">
			<tr align="center">
				<td>${reply.userid}</td>
				<td><fmt:formatDate value="${reply.writedate}" pattern="MM/dd HH:mm"/></td>
				<td>${reply.content}</td>
				<td>
					<c:if test="${reply.userid == loginUser.userid}" >		<!-- 로그인된 사람과 댓글 쓴 사람이 같다면 -->
						<input type="button" value="삭제" onClick="location.href='board.do?command=deleteReply&num=${reply.replynum}&boardnum=${reply.boardnum}'">
					</c:if>&nbsp;
				</td>
			</tr>
		</c:forEach>
	</table>
</form>
</div>
</body>
</html>