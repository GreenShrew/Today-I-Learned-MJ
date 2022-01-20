<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html" %>	<!-- member폴더의 sub_img, menu 파일이 아니라 product 폴더에 있는 파일을 쓰는것이다! -->
<%@ include file="sub_menu.html" %>	<!-- 그리고 sub_img, menu의 내용을 수정! -->

<article>
<div id="itemdetail" style="flaot:left">
<h1>Item</h1>
<form method="post" name="formm">
	<fieldset><legend>Item detail Info</legend>
		<span style="float:left; margin-right:20px;">
		<img src="product_images/${productVO.image}" style="border-radius:20px;"/></span>
		<h2>${productVO.name}</h2>
		<label> 가 격 : </label><p>${productVO.price2} 원</p>
		<label> 수 량 : </label><input type="text" name="quantity" size="2" value="1"><br>
		<label>제품설명 : </label><label>${productVO.content}</label>
		<input type="hidden" name="pseq" value="${productVO.pseq}"><br>
	</fieldset>
	<div class="clear"></div>
	<div id="buttons">
		<input type="button" value="장바구니에 담기" class="submit" onclick="go_cart();">
		<input type="button" value="즉시 구매" class="submit" onclick="go_order();">
		<input type="reset" value="취소" class="cancel">
	</div>
</form>
</div>
</article>

<%@ include file="../footer.jsp" %>