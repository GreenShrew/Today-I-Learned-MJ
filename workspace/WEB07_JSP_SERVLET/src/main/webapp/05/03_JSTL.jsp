<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- prefix="c" : JSTL 문법을 사용하기 위해서 태그의 첫 글자를 c 를 사용하겠습니다~ 라는 표시이다.
그리고 c: 로시작하는 "태그"는 jstl 문법이 적용된다. -->
<%-- <c:태그이름> </c:태그이름> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_JSTL</title>
</head>
<body>
<!-- EL에는 없는 JSP 기능의 대부분이 JSTL에서 제공이 된다. 변수, 반복문, if 등등.. -->

단순 출력<br>	<!-- 출력은 EL이 더 편하기 때문에 단순 출력으로는 쓸 일이 거의 없다. -->
JSTL 출력 : <c:out value="Hello"/><br>
EL 출력 : ${"Hello"}
<br><br><br>


변수 생성 및 초기화 1<br>
<c:set var="msg" value="Hello"></c:set><br>
\${msg} = ${msg}
<br><br><br>


변수 생성 및 초기화 2<br>
<c:set var="age">30</c:set><br>
생성한 변수를 EL에 의해 출력<br>
\${age} = ${age}
<br><br><br>


객체 생성<br>	<!-- 예전에 만들었던 MemberBean 이용 -->
<c:set var="member" value="<%=new com.ezen.dto.MemberBean() %>"></c:set>	<!-- 객체 생성 -->
<!-- MemberBean member = new MemberBean(); -->
<!-- 멤버변수 값 변경 -->
<c:set target="${member}" property="name" value="홍길동"></c:set>
<c:set target="${member}" property="userid">Hong</c:set>
EL에 의한 멤버변수 출력 - 객체와 멤버변수 이름만으로 setter 기능이 대체된다.<br>
\${member.name} = ${member.name}<br>
\${member.userid} = ${member.userid}<br>
클래스에 각 멤버변수에 대한 getter와 setter가 존재해야 위의 실행이 가능하다.<hr><br>
<br><br><br>


그외 변수와 출력 기능 - jstl과 el의 혼합 사용<br>
<c:set var="add" value="${10 + 5}"></c:set>
\${add} = ${add}<br>
<c:set var="flag" value="${10 > 5}"></c:set>
\${flag} = ${flag}<br>
<br><br><br>


※ EL은 어디에서나 튀어나올 수 있다.
<input type="text" value="${member.userid}">
</body>
</html>