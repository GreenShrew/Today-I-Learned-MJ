<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/script/board.js"></script>
<link rel="stylesheet" type="text/css" href="/css/board.css" >
</head>
<body>
<div id="wrap" align="center" style="width:100%">
	<form name="frm" action="fileupload" method="post" enctype="multipart/form-data">
		<h1>파일 선택</h1>
		<input type="file" name="image" onchange="selectedimage();">
<!-- 		<input type="submit" value="파일적용"> -->
<!-- 주석처리된 태그로 해도 되지만, 파일이 업로드 되자마자 submit 시키려고 onchange 속성으로 걸었다. -->
	</form>
</div>

</body>
</html>