<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<meta charset="UTF-8">	<!-- 한글이 들어가므로 jsp를 사용했다. -->

<nav id="sub_menu">
<h1>Admin Setting</h1>
<ul>
	<li><a href='shop.do?command=adminProductList&sub=y'>상품리스트</a></li>
	<li><a href='shop.do?command=adminOrderList&sub=y'>주문리스트</a></li>
	<li><a href='shop.do?command=adminMemberList&sub=y'>회원리스트</a></li>
	<li><a href='shop.do?command=adminQnaList&sub=y'>Q&amp;A리스트</a></li>
</ul>
</nav>