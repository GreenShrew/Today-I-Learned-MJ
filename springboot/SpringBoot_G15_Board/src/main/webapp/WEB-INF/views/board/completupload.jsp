<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 업로드될 파일 이름을 imgfilename인 hidden 태그와 id가 image인 div에 넣는다.
div로 인해 이름이 화면에 표시될 것이다. -->
<!-- 그리고 id가 previewimg인 img 태그에 upload 폴더의 image를 넣어준다.
 그리고 hidden인 태그를 inline으로 보이게 만든다. -->
<script type="text/javascript">
	opener.frm.imgfilename.value='${image}';
	opener.document.getElementById('image').innerHTML = '${image}';
	opener.document.getElementById('previewimg').setAttribute('src', '/upload/' + '${image}');
	opener.document.getElementById('previewimg').style.display='inline';
	self.close();
</script>
</head>
<body>

</body>
</html>