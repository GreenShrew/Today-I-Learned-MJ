<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
<h1>상품 리스트</h1>
<form name="frm" method="post"><!-- 검색창과 상품 등록버튼 -->
	<table>
		<tr><td width="642">상품명<input type="text" name="key" value="${key}">
			<input class="btn" type="button" name="btn_search" value="검색" onClick="go_search('adminProductList');">
			<input class="btn" type="button" name="btn_total" value="전체보기" onClick="go_total('adminProductList');">
			<input class="btn" type="button" name="btn_write" value="상품등록" onClick="go_wrt();"></td>
		</tr>
	</table>
</form>

<table id="productList">
	<tr><th>번호</th><th>상품명</th><th>원가</th><th>판매가</th><th>등록일</th><th>사용유무</th></tr>
	<c:forEach items="${productList}" var="productVO">
		<tr><td height="23" align="center">${productVO.pseq}</td>
			<td style="text-align:left; padding-left:50px;">
				<a href="#" onClick="go_detail('${productVO.pseq}')">${productVO.name}</a></td>
			<td><fmt:formatNumber value="${productVO.price1}"/></td>
			<td><fmt:formatNumber value="${productVO.price1}"/></td>
			<td><fmt:formatDate value="${productVO.indate}"/></td>
			<td><c:choose>
				<c:when test='${productVO.useyn=="n"}'>미사용</c:when>
				<c:otherwise>사용</c:otherwise>
			</c:choose></td></tr>
	</c:forEach>
</table>

<br/><br/>	<!-- 아래는 페이지 숫자들을 표시하는 코드...였으나 따로 빼서 인클루드 함. -->

<jsp:include page="/admin/paging/paging.jsp">
	<jsp:param name="command" value="shop.do?command=adminProductList"/>
</jsp:include>
<!-- include로 paging.jsp 를 불러오면서 그 페이지 안에 command 값으로 파라미터를 보내준다. -->
<br><br/>
</article>

<%@ include file="/admin/footer.jsp"%>