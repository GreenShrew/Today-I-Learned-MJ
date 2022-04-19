<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/admin/admin.css">
<script type="text/javascript" src="/admin/product.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

$(function(){
	$('#myButton').click(function(){
		var formselect = $("#fileupForm")[0];   // 지목된 폼을 변수에 저장
		var formdata = new FormData(formselect);   // 전송용 폼 객체에 다시 저장
		
		// ajax : 웹페이지 새로고침이 필요없는 request(요청)
		$.ajax({
			url:"<%=request.getContextPath() %>/fileup",
			type:"POST",
			enctype:"multipart/form-data",
			async: false,
			data: formdata,
	    	timeout: 10000,
	    	contentType : false,
	        processData : false,
	        success : function(data){
	            if(data.STATUS == 1){
	            	//동적으로 div태그 달아주기.
	            	$("#filename").empty();	// 기존의 oldfilename 지우기!
	            	$("#filename").append("<div>"+data.FILENAME+"</div>");
	            	$("#image").val(data.FILENAME);
	            }
	        },
	        error: function() {
				alert("실패");
			}
		});
	});
});

</script>

<body>
<div id="wrap">
	<header>			
		<div id="logo">
			<a href="admin"> 
				<img src="<c:url value='admin/bar_01.gif'/>"  style="float:left;">
				<img src="<c:url value='admin/text.gif'/>">
			</a>
		</div>	
		<input class="btn" type="button" value="logout" style="float: right;"
		onClick="location.href='adminLogout'">			
	</header>
	<div class="clear"></div>