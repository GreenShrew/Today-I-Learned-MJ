<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_result</title>
</head>
<body>
<h3>
글쓴이 : ${name}<br>
제목 : ${title}<br>
이미지 : <br><img src="upload/${fileName}" width="200">
<!-- 폴더명만 지정해주면 쓸 수 있다. -->
</h3>
</body>
</html>