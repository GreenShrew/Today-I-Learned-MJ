<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_time</title>
</head>
<body>
<h2>안녕하세요</h2>
<h2>JAVA SERVER PAGE(JSP)</h2>

<!-- 실행되어야 할 명령을 쓸때 -->
<% java.util.Date d = new java.util.Date(); %>
<!-- HTML로 페이지를 구성하던 중, JSP에 의한 컨텐츠가 중간에 나와야 한다면 필요한곳에 JSP 명령을 쓴다. -->
<%-- 현재 jsp 파일안에 html 문법 사이로 jsp 문법이 껴들어 코딩될때는 <% %> 를 사용한다. --%>

<!-- 화면에 표현해야 할 명령을 쓸 때 -->
<h2>현재시간 : <%= new java.util.Date() %></h2>
<%-- 다만 페이지에 출력될 내용을 기술한다면 <%= %>를 쓰고 변수명이나 출력할 내용을 쓴다. --%>


<!-- 일반 텍스트와 JSP 명령의 주석처리 -->

<!-- 안녕하세요 - 일반 텍스트에 주석처리 -->
<%-- 안녕하세요 오늘은 <%= new java.util.Date() %> 입니다. --%>


<%-- <% jsp 명령 %> : 명령의 실행 --%>
<%-- <%= 변수 또는 출력 내용 %> : 웹페이지에 출력 --%>
<!-- jsp : 서버에서 계산하거나 처리할 명령을 써서 실행시키고, 그 결과가 웹페이지에 jsp 문법에 의해 표시되는 페이지이다. -->
<h2> <%= d%> => 계산된 현재날짜 시간을 body의 해당 위치에 표시</h2>


<!-- jsp 명령은 html 태그와 함께 파일로 저장되어 서버에 보관된다. 클라이언트의 요청을 받으면 해당 파일(~.jsp)이 클라이언트로 전송되어
웹브라우저에 표시가 되게 되는데, 그전에 jsp 명령은 이미 실행되어서 결과만 html 태그와 같이 전송되어진다. -->
<!-- 페이지에서 우클릭 - 페이지 소스 보기 를 선택하면, java.util.Date()가 나오는게 아니라, 이것이 실행되어서 그 결과 Tue Dec 28 09:49:22 KST 2021 이런 식으로 나온다.
즉, 서버에서 JSP 문법을 실행해서 브라우저로 전송된다는 것이다. -->
</body>
</html>