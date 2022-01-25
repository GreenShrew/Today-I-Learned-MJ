<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article>
<h1>상품 상세 보기</h1>
<table id="list">
	<tr><th>상품 분류</th><td colspan="5">${kind}</td></tr>
	<tr><th align="center">상품명</th><td colspan="5">${productVO.name}</td></tr>
	<tr><th>원가 [A]</th><td width="60">${productVO.price1}</td>
		<th>판매가 [B]</th><td width="60">${productVO.price2}</td>
		<th>[B-A]</th><td>${productVO.price3}</td>
	<tr><th>상세설명</th><td colspan="5"><pre>${productVO.content}</pre></td></tr>
	<tr><th>상품이미지</th>	<td colspan="5" align="center">
		<img src="product_images/${productVO.image}" width="200pt"></td></tr>
</table>
<input class="btn" type="button" value="수정" onClick="go_mod('${productVO.pseq}')">
<input class="btn" type="button" value="목록" onClick="go_mov()">
</article>

<%@ include file="/admin/footer.jsp"%>