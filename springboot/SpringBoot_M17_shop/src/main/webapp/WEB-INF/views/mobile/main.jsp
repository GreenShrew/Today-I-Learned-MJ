<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<article>
<div id="sub_img"><img src="images/product/sub_img.jpg"/></div>
<nav id="sub_menu">
	<ul>
			<li><a href="mcatagory?kind=1">Heels</a></li>
			<li><a href="mcatagory?kind=2">Boots</a></li>
			<li><a href="mcatagory?kind=3">Sandals</a></li>
			<li><a href="mcatagory?kind=4">Sneakers</a></li>
			<li><a href="mcatagory?kind=5">Sleeper</a></li>
			<li><a href="mcatagory?kind=6">On Sale</a></li>
		</ul>
</nav><br/><br/><fmt:setLocale value="ko_KR"/>
<div id="front">
	<div style="width:100%; margin:0 auto;">
		<h2>NEW ITEM</h2><br/>
		<c:forEach items="${newProductList}" var="${productVO.PSEQ}">
			<div class="item"><a href="mproductDetail?pseq=${productVO.PSEQ}">
				<img src="<c:url value='product_images/${priductVO.IMAGE}'/>"/>
				<br>${productVO.NAME}<br>${productVO.PRICE2}</a>
			</div>
		</c:forEach>
	</div>
</div>
<div class="clear"></div><br/><br/>
<div id="front">
	<div style="width:100%; margin:0 auto;">
		<h2>BEST ITEM</h2><br/>
		<c:forEach items="${bestProductList}" var="${productVO.PSEQ}">
			<div class="item"><a href="mproductDetail?pseq=${productVO.PSEQ}">
				<img src="<c:url value='product_images/${priductVO.IMAGE}'/>"/>
				<br>${productVO.NAME}<br>${productVO.PRICE2}</a>
			</div>
		</c:forEach>
	</div>
</div>
</article>
<%@ include file="include/footer.jsp" %>