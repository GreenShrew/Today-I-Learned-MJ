<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article>
<h1>회원리스트</h1>
<form name="frm" method="post">
<table style="float:right;">
	<tr><td>회원 이름 <input type="text" name="key" value="${key}">
	<input class="btn" type="button" value="검색" onclick="go_search('adminMemberList')">
	<input class="btn" type="button" name="btn_total" value="검색" onclick="go_total('adminMemberList')"></td></tr>
</table>
<br>
<table id="orderList">
	<tr><th>아이디(탈퇴여부)</th><th>이름</th><th>이메일</th><th>우편번호</th><th>주소</th><th>전화</th><th>가입일</th></tr>
	<c:forEach items="${memberList}" var="memberVO">
		<tr><td>${memberVO.id}
			<c:choose>
				<c:when test='${memberVO.useyn=="y"}'>
					<input type="checkbox" name="useyn" disabled="disabled">
				</c:when>
				<c:otherwise>
					<input type="checkbox" name="useyn" checked="checked" disabled="disabled">
				</c:otherwise>
			</c:choose></td>
			<td>${memberVO.name}</td><td>${memberVO.email}</td><td>${memberVO.zip_num}</td>
			<td>${memberVO.address}</td><td>${memberVO.phone}</td><td><fmt:formatDate value="${memberVO.indate}"/></td></tr>
	</c:forEach>
</table>
<jsp:include page="/admin/paging/paging.jsp">
	<jsp:param value="shop.do?command=adminMemberList" name="command"/>
</jsp:include>
</form>
</article>
<%@ include file="/admin/footer.jsp"%>