<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_Sum</title>
</head>
<body>
<!-- JSP는 JAVA에서 사용하던 거의 모든 문법이 똑같이 사용된다. -->

<%
	int sum = 0;
	for(int i=1; i<=100; i++){
		sum+=i;
	}
%>
<h2><%= sum %></h2>


<%
	sum = 0;
	for(int i=1; i<=100; i++){
		sum+=i;
%>
<h2><%= sum %> 100번 더하기</h2>
<%
	} 
%>
<!-- JSP 명령들 사이에 HTML 같은 요소들이 끼어들어야 한다면 JSP 영역을 끝내고 해당 내용을 기술한다.
그리고 다시 JSP 영역을 시작하면 된다. 한 페이지 안에서 JSP 명령은 중간에 영역이 끝나고 다시 시작해도
 한 프로그램처럼 이어진다. -->
</body>
</html>