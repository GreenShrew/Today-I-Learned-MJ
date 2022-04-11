<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link  rel="stylesheet" href="/css/mobile.css">  
<script type="text/javascript" src="/script/mmember.js"></script>
<script type="text/javascript" src="/script/mmypage.js"></script>

</head>
<body>

<!-- 메인메뉴 -->
<div id="wrap">
<header>
		<c:choose>
			<c:when test="${empty loginUser}">
				<nav id="top_menu">
					<ul>
						<li><a href="mloginForm">LOGIN</a></li>
						<li><a href="mcartList">JOIN</a></li>
						<li><a href="mcartList">CART</a></li>
						<li><a href="mmyPage">MY PAGE</a></li>
						<li ><a href="mqnaList" >Q&amp;A(1:1)</a></li>
					</ul>
				</nav>
			</c:when>
    		<c:otherwise>
    		<nav id="top_menu">
    			<ul>
	       			<li><span style="color:yellow;">${loginUser.USERID}</span>
	       				<a href="mmemberEditForm"> · 정보수정</a> <a href="logout"> · LOGOUT</a></li>
	       				<li><a href="mcartList">CART</a></li>
						<li><a href="mmyPage">MY PAGE</a></li>
						<li ><a href="mqnaList" >Q&amp;A(1:1)</a></li>
					</ul>
				</nav>
			</c:otherwise>
		</c:choose>
	<div id="logo"><a href="/">Shoes Shop</a></div>
</header>