<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
// userAgent는 사용중인 운영체제를 얻는 메서드
if((navigator.userAgent.match(/iPhone/i)) || (navigator.userAgent.match(/iPod/i))
		|| (navigator.userAgent.match(/iPad/i)) || (navigator.userAgent.match(/Windows CE/i))
		|| (navigator.userAgent.match(/Symbian/i)) || (navigator.userAgent.match(/BlackBerry/i))
		|| (navigator.userAgent.match(/Android/i))){
	window.location.href='mobilemain';
}else{
	window.location.href='webmain';
}
</script>
</body>
</html>