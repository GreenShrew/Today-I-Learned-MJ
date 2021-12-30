<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 083_useBeanAction_do.jsp
String id = request.getParameter("userid");
String name = request.getParameter("name");
String pwd = request.getParameter("pwd");
String nickname = request.getParameter("nickname");
String phone = request.getParameter("phone");
String email = request.getParameter("email");
%>

<!-- dto 객체 생성 & request에 getAttrubute로 저장까지 한번에 실행 -->
<jsp:useBean id="member" class="com.ezen.dto.MemberBean" scope="request"/>

<!-- 전달된 파라미터로 멤버 변수들을 변경 -->
<jsp:setProperty name="member" property="name" value="<%=name %>"/>
<jsp:setProperty name="member" property="userid" value="<%=id %>"/>
<jsp:setProperty name="member" property="pwd" value="<%=pwd %>"/>
<jsp:setProperty name="member" property="nickname" value="<%=nickname %>"/>
<jsp:setProperty name="member" property="phone" value="<%=phone %>"/>
<jsp:setProperty name="member" property="email" value="<%=email %>"/>

<%
	RequestDispatcher dp = request.getRequestDispatcher("084_useBeanAction.jsp");
	dp.forward(request, response);
%>