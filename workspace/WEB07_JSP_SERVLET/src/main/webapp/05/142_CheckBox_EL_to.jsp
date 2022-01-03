<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>142_CheckBox_EL_to</title>
</head>
<body>
<%-- 체크박스의 다중 선택 value 들이 파라미터로 전달되어 EL로 수신하는 키워드 : ${paramValues.item} --%>
<c:forEach var="item" items="${paramValues.item}" varStatus="status">
	${item} <c:if test="${not status.last}">, </c:if>
</c:forEach><br><br>
</body>
</html>