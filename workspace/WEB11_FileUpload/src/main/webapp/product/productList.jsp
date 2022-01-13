<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productList</title>
<link rel="stylesheet" type="text/css" href="css/product.css">
</head>
<body>
<div id="wrap" align="center">
<h1>상품 리스트 - 관리자 페이지</h1>
<table class="list">
	<tr><td colspan="5" style="border:white; text-align:right">
		<a href="product.do?command=productWriteForm">상품 등록</a></td></tr>
	<tr><th>번호</th><th>이름</th><th>가격</th><th>수정</th><th>삭제</th></tr>
	<!-- 왜 ${product.xxx}라고 쓰는가? 그 이유는 c:forEach에 있다. -->
	<!-- 반복문의 변수명을 product라고 설정했고, 반복문을 Dao - IndexAction에서 request.setAttribute("productList", list); 로 보내진 이름 'productList'의 list들을
	items="${productList}"로 받아서 하나씩 반복한다. -->
	<c:forEach var="product" items="${productList}">
		<tr class="record"><td align="center">${product.code}</td>
			<td><a href="product.do?command=productView&code=${product.code}">	${product.name}</a></td>
			<td align="right">${product.price} 원</td>
			<td align="center"><a href="product.do?command=updateForm&code=${product.code}">상품 수정</a></td>
			<td align="center"><a href="product.do?command=deleteForm&code=${product.code}">상품 삭제</a></td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>