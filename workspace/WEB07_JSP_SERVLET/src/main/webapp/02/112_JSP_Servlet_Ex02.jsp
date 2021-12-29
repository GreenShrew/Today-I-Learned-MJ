<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>112_JSP_Servlet_Ex02.jsp</title>
</head>
<body>
<%
String id = (String) request.getAttribute("id");
String pwd = (String)request.getAttribute("pwd");
String gender = (String)request.getAttribute("gender");
String chk_mail = (String)request.getAttribute("chk_mail");
String content = (String)request.getAttribute("content");
String [] items = (String [])request.getAttribute("items");
String job = (String)request.getAttribute("job");
String [] interests = (String [])request.getAttribute("interests");
%>
아이디 : <%=id %><br />
암호 : <%=pwd %><br />
성별 : <%=gender %><br />
메일수신 : <%=chk_mail %><br />
하고싶은말 : <%=content %><br />
구입항목 : <% for( String s:items) out.print(s + " "); %><br />
직업 : <%=job %><br />
관심 분야 : <% for( String s:interests) out.print(s + " "); %><br />
<br />
 <%-- out.print( s ) : <%=s %> 와 같은 명령  --%>
</body>
</html>