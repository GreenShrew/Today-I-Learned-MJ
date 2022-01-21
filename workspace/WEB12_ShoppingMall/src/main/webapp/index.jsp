<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!-- 메인 이미지 시작 -->
<div id="main_img">
	<img src="images/main_img.jpg" style="border-radius:20px 20px 20px 20px; border:2px solid white;">
</div>

<!-- 신상품 -->
<h2>New Item</h2>
<div id="bestProduct"><!-- css 적용시 이름을 같게 해서 똑같이 만들기 위해 -->
	<c:forEach items="${newList}" var="productVO">
		<div id="item"><!-- 상품 한개에 한칸 -->
			<a href="shop.do?command=productDetail&pseq=${productVO.pseq}">
				<img src="product_images/${productVO.image}"/>
				<h3>${productVO.name} - <fmt:formatNumber value="${productVO.price2}" type="currency"/></h3>
			</a>
		</div>
	</c:forEach>
</div>

<div class="clear"></div>
<!-- 베스트 상품 -->
<h2>Best Item</h2>
<div id="bestProduct">
	<c:forEach items="${bestList}" var="productVO">
		<div id="item"><!-- 상품 한개에 한칸 -->
			<a href="shop.do?command=productDetail&pseq=${productVO.pseq}">
				<img src="product_images/${productVO.image}"/>
				<h3>${productVO.name} - <fmt:formatNumber value="${productVO.price2}" type="currency"/></h3>
			</a>
		</div>
	</c:forEach>
</div>
<%@ include file="footer.jsp" %>