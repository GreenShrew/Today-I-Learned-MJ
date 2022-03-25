<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/adminheaderfooter/header.jsp"%>    
<%@ include file="../../include/sub05/sub_menu.jsp"%>
<article>
<h1>상품수정</h1>  
<form name="frm" method="post" action="productUpdate">
<input type="hidden" name="pseq" value="${dto.pseq}">
<input type="hidden" name="oldImage" value="${dto.image}">
<table id="list">
  <tr><th>상품분류</th><td colspan="5">
    <select name="kind">
      <c:forEach items="${kindList}" var="kind" varStatus="status">
        <c:choose>
          <c:when test="${dto.kind==status.count}">
            	<option value="${status.count}" selected="selected">${kind}</option>
          </c:when>
          <c:otherwise>
            	<option value="${status.count}">${kind}</option>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </select></td></tr>
  <tr> <th>상품명</th><td width="343" colspan="5">
      <input type="text" name="name" size="47" value="${dto.name}"></td></tr>
  <tr><th>원가[A]</th><td width="70">        
      <input type="text" name="price1" size="11"  value="${dto.price1}"></td>
      <th>판매가[B]</th><td width="70">
      <input type="text" name="price2" size="11" value="${dto.price2}"></td>
      <th>[B-A]</th><td width="72">
      <input type="text" name="price3" size="11"  value="${dto.price2-dto.price1}">
    </td> </tr>
  <tr><th>베스트상품</th><td>
      <c:choose>
        <c:when test='${dto.bestyn=="y"}'>
          <input type="checkbox" name="bestyn" value="y" checked="checked">
        </c:when>
        <c:otherwise>
          <input type="checkbox" name="bestyn" value="n">
        </c:otherwise>
      </c:choose></td>        
    <th>사용유무</th> <td>
      <c:choose>
        <c:when test='${dto.useyn=="y"}'>
          <input type="checkbox" name="useyn" value="y" checked="checked">
        </c:when>
      <c:otherwise>
        <input type="checkbox" name="useyn" value="n">
      </c:otherwise>
    </c:choose> </td></tr>
  <tr>
    <th>상세설명</th><td colspan="5">
      <textarea name="content" rows="8" cols="70" >${dto.content}</textarea> </td></tr>
  <tr><th>상품이미지</th> <td colspan="5">
      <img src="/product_images/${dto.image}" width="200pt"> <br>
      
      
      <div id="imageName" style="float:left; font-size:120%;margin-right:20px;font-weight:bold"></div>
      <input type="button" value="이미지선택" onClick="selectFile();">
      <input type="hidden" name="imgfilename" >* 주의 : 이미지를 수정할때에만 선택해주세요
    
    </td> 
  </tr>    
</table>
<input class="btn" type="submit" value="수정" >           
<input class="btn" type="button" value="취소" onClick="go_mov()">
</form> 
</article>
<%@ include file="../../include/adminheaderfooter/footer.jsp"%>