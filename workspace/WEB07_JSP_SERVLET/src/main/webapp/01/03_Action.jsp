<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_Action</title>
</head>
<body>
<!-- 하나의 작업단위(회원가입, 로그인, 게시물 등록 등)을 구성하기 위해 사용되는 입력란, 선택란들은
작업단위별로 아래와 같이 form 태그 안에 넣어서 사용한다. form의 첫번째 기능은 이러한 경계선을 제공하는 것. -->
<form name="joinForm" action="03_Action_to.jsp" method="get">
<!--
 name : 스크립트에서 다른것들과 구분하여 명명하기 위한 이름으로 사용.
 action : 입력한 선택란에 입력하고, 선택한 내용이 전달될 대상 파일. 위에서는 03_Action_to.jsp 파일로 내용을 가지고 간다.
 method : 파일이 전달될 방식. get/post가 있다. get은 일반전송방식, post는 비공개 전송방식을 사용한다.
 -->
	<label for="name"> 이름 </label><span style="color:red;">*</span>
	<input type="text" id="name" name="name" value=""><br>
	<label for="id"> 아이디 </label><span style="color:red;">*</span>
	<input type="text" id="id" name="id" value=""><br>
	<label for="pwd"> 비밀번호 </label><span style="color:red;">*</span>
	<input type="password" id="pwd" name="pwd" value=""><br>
	<label for="pwd_re"> 비밀번호 확인 </label><span style="color:red;">*</span>
	<input type="password" id="pwd_re" name="pwd_re" value=""><br>
	<input type="submit" value="회원가입">
	<input type="reset" value="다시작성">
</form>


<!-- form 태그 안에서 submit 버튼을 이용하는것이 아니라
필요에 따라 일반 버튼 클릭으로 이동할 때, 이동 주소에 전달값을 붙여서 이동시키기도 한다.
링크될 주소 - http://주소/경로/파일이름.jsp?전달name1=전달값1%전달name2=전달값2 ... -->

<br><br>
<a href="03_Action_to.jsp?useritem=superCar">유저아이템만 보내기</a>


<!-- 웹브라우저 주소창에 네임과 벨류로 구성된 주소를 직접 입력해도 링크를 클릭한것과 같이 전달된다. -->
<h3> http://localhost:8090/WEB07_JSP_SERVLET/01/03_Action_to.jsp?useritem=주소에 직접 넣은 item 
<br>위의 주소를 웹브라우저 주소창에 입력하고 엔터를 누르면, 페이지이 유저item에 '주소에 직접 넣은 item'이 출력되게 된다. </h3>
</body>
</html>