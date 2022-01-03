<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>132_ParameterCal_To</title>
</head>
<body>
고전적인 방식
<%
String str1 = request.getParameter("num1");
String str2 = request.getParameter("num2");
int number1 = Integer.parseInt(str1);
int number2 = Integer.parseInt(str2);
%>
<%=number1 %> + <%=number2 %> = <%=number1 + number2 %><br>
<%=str1 %> + <%=str2 %> = <%=str1 + str2 %>

<hr>
EL 방식 : <%-- 보다 깔끔하고 간단한 코드 --%>
${param.num1} + ${param.num2} = ${param.num1+param.num2}	<!-- 산술덧셈 --><br>
${param.num1} + ${param.num2} = ${param.num1+=param.num2}	<!-- 이어붙이기 --><br>

</body>
</html>