<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>
<link rel="stylesheet" type="text/css" href="css/product.css">
</head>
<body>
<div id="wrap" align="center">
<h1>상품 수정 - 관리자 페이지</h1>
<form method="post" enctype="multipart/form-data" action="product.do?command=update">
<!-- <input type="hidden" name="command" value="update"> -->
<!-- 지금까지는 command를 type="hidden"인 input 태그에 넣었지만, enctype="multipart/form-data" 이 속성을 쓴 뒤로는 action에 모두 넣었다.
 따로 input 태그를 쓸 경우 input 태그도 multipart/form-data로 같이 전송되어 데이터를 받을 수 없다...고 설명했는데 다시 한번 더 찾아봐야... -->
<input type="hidden" name="code" value="${product.code}">
<input type="hidden" name="oldPicture" value="${product.pictureurl}">	<!-- 못 보던 태그인데? 기존의 파일 이름을 hidden으로 가지고 같이 간다. -->
<!-- 같이 가지고 가는 이유는, 사진을 수정하지 않을 경우 null값이 되어버려 이전의 그림이 사라진다.
 그렇기 때문에 사용자가 사진을 수정하지 않았을 경우 oldPicture를 선택하여 기존 그림을 추가하는 형식으로 만든다. -->
<table>
	<tr><td>
		<c:choose>
			<c:when test="${empty product.pictureurl}">
				<img src="upload/noname.jpg" width="220" height="300">
			</c:when>
			<c:otherwise>
				<img src="upload/${product.pictureurl}" width="220" height="300">
			</c:otherwise>
		</c:choose>
	</td>
	<td><table border="1">
		<tr><th style="width:80px">상품명</th><td><input type="text" name="name" value="${product.name}" size="80"></td></tr>
		<tr><th>가 격</th><td><input type="text" name="price" value="${product.price}">원</td></tr>
		<tr><th>사 진</th><td><input type="file" name="pictureurl"><br>
			(주의사항 : 이미지를 변경하고자 할때만 선택하시오)</td></tr>
		<tr><th>설 명</th><td><textarea cols="90" rows="10" name="description">${product.description}</textarea></td></tr>
		</table>
	</td></tr>
</table><br>
<input type="submit" value="수정"><input 
</form>
</div>
</body>
</html>