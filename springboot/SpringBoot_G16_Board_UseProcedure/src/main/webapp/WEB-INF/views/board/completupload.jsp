<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	opener.frm.imgfilename.value='${image}';
	opener.document.getElementById('image').innerHTML = '${image}';
	opener.document.getElementById('previewimg').setAttribute('src', '/upload/' + '${image}' );
	opener.document.getElementById('previewimg').style.display='inline';
	self.close();
</script>

</head>
<body>

</body>
</html>