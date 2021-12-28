<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_Checkbox</title>
</head>
<body>
<h2>악세사리</h2>
관심항목을 선택하세요.
<hr>
<form method="get" action="04_Checkbox_to.jsp">
	<input type="checkbox" name="item" value="shoes">신발
	<input type="checkbox" name="item" value="bag">가방
	<input type="checkbox" name="item" value="belt">벨트
	<br>
	<input type="checkbox" name="item" value="cap">모자
	<input type="checkbox" name="item" value="watch">시계
	<input type="checkbox" name="item" value="diamond">쥬얼리<br>
	<input type="submit" value="전송">
</form>

<br><br>
<h3>http://localhost:8090/WEB07_JSP_SERVLET/01/04_Checkbox_to.jsp?item=신발&item=가방&item=벨트
<br>위 주소를 복사해서 브라우저 주소창에 붙여넣고 엔터를 누르자.</h3>
</body>
</html>