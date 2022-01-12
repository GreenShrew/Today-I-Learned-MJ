<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_Upload</title>
</head>
<body>
<!-- 파일 업로드 기능이 포함된 form은 반드시 enctype="multipart/form-data" 옵션을 추가해주어야 한다. 
 또한, method는 반드시 post여야 한다. -->
<form action="upload.do" method="post" enctype="multipart/form-data">
	글쓴이 : <input type="text" name="name"><br>
	제 &nbsp; 목 : <input type="text" name="title"><br>
	파일 지정하기 : <input type="file" name="uploadFile"><br>
	<input type="submit" value="전송">
</form><br>
<!-- <img src="Upload/jquery.jpg" width="300"/> -->
</body>
</html>