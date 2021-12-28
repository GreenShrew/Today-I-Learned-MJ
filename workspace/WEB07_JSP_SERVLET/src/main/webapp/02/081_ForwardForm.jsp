<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>081_ForwardForm</title>
</head>
<body>

<!-- 링크주소를 이용하지 않고 페이지 이동시에 자료를 전달할 수 있는 객체 : Forward -->

입장하려면 나이를 입력하세요. <br>
<form action="082_Forward_do.jsp">
	<input type="text" name="age">
	<input type="hidden" name="abc" value="가나다라">
	<input type="submit" value="입장">
</form>

</body>
</html>