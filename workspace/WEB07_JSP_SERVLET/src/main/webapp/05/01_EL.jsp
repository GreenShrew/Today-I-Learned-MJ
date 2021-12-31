<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_EL</title>
</head>
<body>

<!-- 표현 언어(EL, Expression Language) : JSP의 전달값이나 변수값 등 자료를 출력할때의 번거로움을
간단히 해결하기 위해 만들어진 출력 문법이다. JSP 문법을 html5에서 좀더 구분하기 쉽고, 오류를 줄여서 운용하기 위해 개발된 언어이다.
주로 pageContext, request, session, application에 전달되는 Attribute의 값을 getter를 이용하지 않고 출력할때 많이 사용한다. -->

JSP 문법 사용 1 : <%="Hello" %><br>
JSP 문법 사용 2 : <%out.println("Hello"); %><br>
EL 문법 사용 : ${"Hello"}<br>


<!-- #EL로 표현 가능한 것들! -->

<br><br>
정수형 : ${10} <br>
실수형 : ${5.6} <br>
문자열형 : ${"홍길동"} <br>
논리형 : ${true} <br>
null : ${null} <br>

<br><br>

<!-- 산술 연산 -->
10과 2의 합 : ${ 10+2 }<br>
<!-- \${ 10-2 }는 모양 그대로 출력, ${ 10-2 }는 계산된 결과 출력 -->
\${ 10 - 2 } : ${ 10 - 2 }<br>
\${ 10 * 2 } : ${ 10 * 2 }<br>
\${ 10 / 2 } : ${ 10 / 2 }<br>
\${ 10 % 3 } : ${ 10 % 3 }<br>
\${ 10 mod 3 } : ${ 10 mod 3 }<br>

<br><br>

<!-- 관계 연산(비교 연산) -->
\${ 10 == 2 } = ${ 10 == 2 }<br>
\${ 10 eq 2 } = ${ 10 eq 2 }<br>	<!-- 좌항과 우항이 같은가 -->
\${ 10 < 2 } = ${ 10 < 2 }<br>
\${ 10 lt 2 } = ${ 10 lt 2 }<br>		<!-- 좌항이 우항보다 큰가 -->
\${ 5 >= 4 } = ${ 5 >= 4 }<br>
\${ empty("") } = ${ empty("") }<br>	<!-- 괄호안의 내용이 비어있는가 -->

<!-- 
eq : ==
ne : !=
lt : <
gt : >
le : <=
ge : >=
 -->


<br><br>

<!-- 서로 다른 자료형간의 연산 -->
\${ "2" + 5 } = ${ "2" + 5 }<br>	<!-- 특이하게도 "2"가 문자열임에도 숫자와 같이 연산이 된다 -->
\${ "2" * 5 } = ${ "2" * 5 }<br>
\${ null + 1 } = ${ null + 1 }<br>

<br><br>

<!-- 문자열 연결(이어붙이기) -->
<%-- \${"문자" + "열"} = ${"문자" + "열"}	<-- 이 연산은 에러다. --%>
<%-- 문자열 연결(EL 3.0 추가) --%>
\${"문자" += "열 " += "연결"} = ${"문자" += "열 " += "연결"}<br>

<br><br>

<!-- 서버 객체의 내용을 getAttribute 메소드 없이 사용 -->
<%
request.setAttribute("name", "홍길동");
pageContext.setAttribute("name", "홍길서");
session.setAttribute("name", "홍길남");
application.setAttribute("name", "홍길북");
%>

JSP 문법 1 : <%=request.getAttribute("name") %><br>
JSP 문법 2 : <% String str = (String) request.getAttribute("name"); %>
				<%=str %><br>
				
EL 문법 : ${name}<br> 	<!-- key 값이 name으로 중복되어있다. 출력 우선순위는 수명이 짧은 내용이 출력된다. -->
EL 문법 : ${requestScope.name}<br>
EL 문법 : ${sessionScope.name}<br>
EL 문법 : ${applicationScope.name}<br>	<!-- 우선순위가 낮은 key의 값을 출력하고 싶을때는 이런식으로 코드를 만든다. -->
</body>
</html>