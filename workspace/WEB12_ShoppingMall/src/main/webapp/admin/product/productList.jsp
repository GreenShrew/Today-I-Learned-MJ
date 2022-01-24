<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
<h1>상품 리스트</h1>
<form name="frm" method="post"><!-- 검색창과 상품 등록버튼 -->
<table>
		<tr><td width="642">상품명<input type="text" name="key" value="${key}">
			<input class="btn" type="button" name="btn_search" value="검색" onClick="go_search();">
			<input class="btn" type="button" name="btn_total" value="전체보기" onClick="go_total();">
			<input class="btn" type="button" name="btn_write" value="상품등록" onClick="go_wrt();"></td>
		</tr>
	</table>
</form>

<table id="productList">
	<tr><th>번호</th><th>상품명</th><th>원가</th><th>판매가</th><th>등록일</th><th>사용유무</th></tr>
	<c:forEach items="${productList}" var="productVO">
		<tr><td height="23" align="center">${productVO.pseq}</td>
			<td style="text-align:left; padding-left:50px;">
				<a href="#" onClick="go_detail('${rpoductVO.pseq}')">${productVO.name}</a></td>
			<td><fmt:formatNumber value="${productVO.price1}"/></td>
			<td><fmt:formatNumber value="${productVO.price1}"/></td>
			<td><fmt:formatDate value="${productVO.indate}"/></td>
			<td><c:choose>
				<c:when test='${productVO.useyn=="n"}'>미사용</c:when>
				<c:otherwise>사용</c:otherwise>
			</c:choose></td></tr>
	</c:forEach>
</table>

<br/><br/>	<!-- 아래는 페이지 숫자들 -->
	<div id="paging" align="center" style="font-size:110%; font-weight:bold;">
		<c:url var="action" value="shop.do?command=adminProductList" />
		<c:if test="${paging.prev}">
			<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
		</c:if>
		
		<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
			<c:choose>
				<c:when test="${paging.page==index}">
					<span style="color:red">${index}&nbsp;</span>
				</c:when>
				<c:otherwise>
					<a href="${action}&page=${index}">${index}</a>&nbsp;
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${paging.next}">
			<a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
		</c:if>
	</div>
</article>

<%@ include file="/admin/footer.jsp"%>