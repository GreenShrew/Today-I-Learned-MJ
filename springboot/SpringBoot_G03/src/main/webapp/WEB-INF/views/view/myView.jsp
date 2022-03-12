<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%  out.println("Model(Sub) : Hello World");%></h1>
<h1>${ObjectTest}</h1>
<h1>${lists}</h1>
<br>
<c:forEach var="mylist" items="${lists}">
    <h1>${mylist}</h1>
</c:forEach>
</body>
</html>