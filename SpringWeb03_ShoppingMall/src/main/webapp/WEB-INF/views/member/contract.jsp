<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/resources/headerfooter/header.jsp" %>
<%@ include file="/resources/sub01/sub_image.html" %> 
<%@ include file="/resources/sub01/sub_menu.html" %>

<article>
<form id="join" action="joinForm" method="post" name="formm">
	 언제나 새로운 즐거움이...
	 <textarea rows="15" cols="100">
	 .....
	 </textarea>
	<br><br>
<div style="text-align:center;">
	<input type="radio" name="okon">동의함&nbsp;&nbsp;&nbsp;
	<input type="radio" name="okon" checked> 동의안함
</div>

<input type="button" value="Next" class="submit" onclick="go_next()" style="float:right;">
</form>

</article>
<%@ include file="/resources/headerfooter/footer.jsp" %>