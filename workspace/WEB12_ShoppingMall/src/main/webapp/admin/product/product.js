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



function go_mov(){
	location.href = "shop.do?command=adminProductList";
}


function go_mod(pseq){
	var url = "shop.do?command=adminProductUpdateForm&pseq="+pseq;
	location.href = url;
	// document.frm.action = url;
	// document.frm.submit();
	// submit을 사용할 필요가 없다. 왜냐하면 상품을 수정하고자 할 때는 수정할 상품의 번호만 가져가서 이걸 DB에서 조회해다가 쓰면 되기 때문이다.
	// 따라서 그냥 form 안의 모든 내용을 가져가는 submit이 아니라 가져온 pseq만 보내는 location.href를 사용한다.
}





function go_mod_save(){
	if(document.frm.kind.value == ''){
		alert('상품분류를 선택하세요.');
		document.frm.kind.focus();
	}else if(document.frm.name.value == ''){
		alert('상품명을 입력하세요.');
		document.frm.name.focus();
	}else if(document.frm.price1.value == ''){
		alert('원가를 입력하세요.');
		document.frm.price1.focus();
	}else if(document.frm.price2.value == ''){
		alert('판매가를 입력하세요.');
		document.frm.price2.focus();
	}else if(document.frm.content.value == ''){
		alert('상품상세를 입력하세요.');
		document.frm.content.focus();
	}else{
		if(confirm('수정하시겠습니까?')){	// confirm() : 괄호 안의 내용을 경고로 알리고, 예 아니오 버튼에서 예를 누르면 true를 반환
			document.frm.action = "shop.do?command=adminProductUpdate";
			document.frm.submit();
		}
	}
}