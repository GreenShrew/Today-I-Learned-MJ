<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/headerfooter/header.jsp" %>

<div id="main_img"><img src="/images/main_img.jpg" 
    			style="border-radius:20px 20px 20px 20px;border:2px solid white;"></div>

<div id="front"><h2>New Item</h2>   
<div id="bestProduct">
	<c:forEach items="${newProductList}"  var = "productVO" >
		<div id="item"><!-- 상품 하나 -->
			<a href="productDetail?pseq=${productVO.PSEQ}">
				<img src="/product_images/${productVO.IMAGE}" /> <!-- 상품이미지 -->
				<h3> ${productVO.NAME} - <fmt:formatNumber value="${productVO.PRICE2}" type="currency" /></h3> <!-- 상품명-가격  -->
			</a>
		</div>
	</c:forEach>
</div>

<div class="clear"></div>

<!-- 베스트 상품 -->
<div id="front"><h2> Best Item</h2>  
<div id="bestProduct">
	<c:forEach items="${bestProductList}"  var = "productVO" >
		<div id="item">
			<a href="productDetail?pseq=${productVO.PSEQ}">
				<img src="/product_images/${productVO.IMAGE}" />
				<h3> ${productVO.NAME} - <fmt:formatNumber value="${productVO.PRICE2}" type="currency" /></h3>
			</a>
		</div>
	</c:forEach>
</div>
<div class="clear"></div>

<%@ include file="include/headerfooter/footer.jsp" %>