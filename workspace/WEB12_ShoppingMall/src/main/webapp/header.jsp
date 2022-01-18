<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link href="css/shopping.css" rel="stylesheet">
<script src="member/member.js"></script>
<script src="mypage/mypage.js"></script>
</head>
<body>

<div id="wrap">
<header><!-- 로고, 주상단메뉴, 카테고리 메뉴 등이 표시되는 영역 -->
	<div id="logo"><!-- 메인 로고 이미지 -->
		<a href="shop.do?command=index">
			<img src="images/logo.png" width="180" height="100"/>
		</a>
	</div>
	
	<nav id="top_menu"><!-- 상단 메뉴 : 로그인, CART, MyPage 등... -->
		<ul>
			<c:choose>
				<c:when text="${empty loginUser}">
					<li>LOGIN</li>
					<li>JOIN</li>
				</c:when>
				<c:otherwise>
					<li>${loginUser.name}(${loginUser.id})</li>
					<li><a href="shop.do?command=editForm&id=${loginUser.id}">정보수정</a></li>
					<li><a href="shop.do?command=logout">LOGOUT</li>
			</c:choose>
			<li>CART</li>
			<li>MY PAGE</li>
			<li>Q&amp;A</li>
		</ul>
	</nav>
</header>
