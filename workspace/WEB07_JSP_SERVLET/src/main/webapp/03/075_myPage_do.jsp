<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 075_myPage_do
if(session.getAttribute("loginUser")==null){
	response.sendRedirect("071_LoginForm.jsp");
}else{
	response.sendRedirect("076_myPage.jsp");
}
%>