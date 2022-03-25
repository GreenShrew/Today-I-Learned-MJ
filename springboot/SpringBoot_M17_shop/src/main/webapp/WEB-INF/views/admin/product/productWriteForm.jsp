<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/adminheaderfooter/header.jsp"%>    
<%@ include file="../../include/sub05/sub_menu.jsp" %>
<article>
<h1>상품등록</h1>  
<form name="frm" method="post" enctype="multipart/form-data">
<table id="list">
	<tr><th>상품분류</th><td colspan="5">
		<select name="kind">
    		<c:forEach items="${kindList}" var="kind" varStatus="status">
      			<option value="${status.count}">${kind}</option>
   			</c:forEach>
  		</select></td>
	<tr><th>상품명</th> <td width="343" colspan="5">
	       <input type="text" name="name" size="47" maxlength="100" > </td></tr>
	<tr><th>원가[A]</th> <td width="70"><input type="text" name="price1" size="11" ></td>
		<th>판매가[B]</th><td width="70"><input type="text" name="price2" size="11" ></td>
	    <th>[B-A]</th><td width="72"><input type="text" name="price3" size="11"></td></tr>
	<tr><th>상세설명</th><td colspan="5">
	      <textarea name="content" rows="8" cols="70" ></textarea></td></tr>
    
    <!-- <tr><th>상품이미지</th><td width="343" colspan="5"><input type="file" name="image"></td></tr>-->
    
    
    <tr><th>상품이미지</th><td width="343" colspan="5">
   		<input type="hidden" name="image" id="image">
	</td></tr>
    
    
</table>
<input class="btn" type="button" value="등록" onClick="go_save()">           
<input class="btn" type="button" value="취소" onClick="go_mov()"><br/>
<div id="msg" ></div>
</form> 

<form name="fromm" id="fileupForm" method="post" enctype="multipart/form-data">
			<input type="file" name="fileimage"><input type="button" id="myButton" value="추가">
</form>
<div id="filename"></div>

</article>
<%@ include file="../../include/adminheaderfooter/footer.jsp"%>






