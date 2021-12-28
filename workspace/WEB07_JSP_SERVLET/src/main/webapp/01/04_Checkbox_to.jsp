<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_Checkbox_to</title>
</head>
<body>
<%
String [] items = request.getParameterValues("item");
%>

<%
if(items == null){
%>
	<h3>선택한 항목이 없습니다.</h3>
<%
}else{
%>
	<h3>당신이 선택한 항목입니다.</h3>
	<%
	for(String it : items){
	%>
		<%=it %>&nbsp;&nbsp;
	<%
	}
}
%>
</body>
</html>