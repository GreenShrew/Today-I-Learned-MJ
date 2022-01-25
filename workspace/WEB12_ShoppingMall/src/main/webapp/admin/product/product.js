function go_search(){
	if(document.frm.key.value == ""){
		alert("검색버튼 사용에는 검색어 입력이 필수입니다.");
		return;
	}
	var url = "shop.do?command=adminProductList&page=1";	// 검색어로 검색한 결과의 1페이지로 이동한다.
	document.frm.action = url;
	document.frm.submit();
}



function go_total(){
	document.frm.key.value = "";
	document.frm.action = "shop.do?command=adminProductList&page=1";
	document.frm.submit();
}




function go_wrt(){
	document.frm.action = "shop.do?command=adminProductWriteForm";
	document.frm.submit();
}




function go_save(){
	var theForm=document.frm;	// 매번 document.frm을 쓰기 번거로워서 저장했다.
	if(theForm.kind.value == ""){
		alert("상품분류를 선택하세요.");
		theForm.kind.focus();
	}else if(theForm.name.value == ""){
		alert("상품명을 입력하세요.");
		theForm.name.focus();
	}else if(theForm.price1.value == ""){
		alert("원가를 입력하세요.");
		theForm.price1.focus();
	}else if(theForm.price2.value == ""){
		alert("판매가를 입력하세요.");
		theForm.price2.focus();
	}else if(theForm.content.value == ""){
		alert("제품상세를 입력하세요.");
		theForm.content.focus();
	}else if(theForm.image.value == ""){
		alert("상품 이미지를 입력하세요.");
		theForm.image.focus();
	}else {
		theForm.action = "shop.do?command=adminProductWrite";
		theForm.submit();
	}
}





function cal(){
	if(document.frm.price2.value == "" || document.frm.price1.value == ""){
		return;
	}
	document.frm.price3.value = document.frm.price2.value - document.frm.price1.value;
}







function go_detail(pseq){
	var url = "shop.do?command=adminProductDetail&pseq=" + pseq;
	document.frm.action = url;
	document.frm.submit();
}