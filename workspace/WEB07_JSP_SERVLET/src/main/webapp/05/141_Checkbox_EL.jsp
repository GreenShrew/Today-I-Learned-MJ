<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>141_Checkbox_EL</title>
</head>
<body>

<h2>악세사리</h2>
관심항목을 선택해주세요
<hr>
<form method="get" action="142_CheckBox_EL_to.jsp">
	<input type="checkbox" name="item" value="신발"> 신발
	<input type="checkbox" name="item" value="가방"> 가방
	<input type="checkbox" name="item" value="벨트"> 벨트<br>
	<input type="checkbox" name="item" value="모자"> 모자
	<input type="checkbox" name="item" value="시계"> 시계
	<input type="checkbox" name="item" value="주얼리"> 주얼리<br>
	<input type="submit" value="전송">
</form>
</body>
</html>