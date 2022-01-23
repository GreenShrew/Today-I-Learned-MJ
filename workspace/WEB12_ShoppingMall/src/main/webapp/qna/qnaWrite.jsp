<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.jsp" %>
<article>
<h2> 1:1 고객 게시판 </h2>
<h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>    
<form name="formm" method="post"	action="shop.do">
	<input type="hidden" name="command" value="qnaWrite">
	<fieldset> 
		<legend>Board Info</legend>  
	    <label>Title</label><input type="text" name="subject"  size="60" ><br>
		<label>Content</label><textarea rows="8" cols="65" name="content"></textarea>
	</fieldset>
	<div class="clear"></div>
	<div id="buttons" style="float:right">
		<input type="submit"  value="글쓰기"     class="submit"> 
		<input type="reset"   value="취소"     class="cancel">
		<input type="button"  value="쇼핑 계속하기"  class="submit" onclick="location.href='shop.do?command=index'">
	</div>
</form>
</article>
<!-- 
	주말간 작업
	1. 게시글을 쓰고 글쓰기 버튼을 클릭하면  QnaWriteAction 으로 이동하여
		화면에 사용자가 쓴 내용을 레코드를 추가합니다-별도 QnaDao 내부 메서드제작
	2. 게시글 등록을 마치고    qnaList.jsp  로 이동한다 -->
<%@ include file="../footer.jsp" %>   