function go_search(comm){
	if(document.frm.key.value == ""){
		alert("검색버튼 사용에는 검색어 입력이 필수입니다.");
		return;
	}
	var url = "shop.do?command=" + comm + "&page=1";	// 검색어로 검색한 결과의 1페이지로 이동한다.
	document.frm.action = url;
	document.frm.submit();
}

/*
function go_search_order(){
	if(document.frm.key.value == ""){
		alert("검색어를 입력해주세요.");
		return;
	}
	var url = "shop.do?command=adminOrderList&page=1";
	document.frm.action = url;
	document.frm.submit();
}
*/




function go_total(comm){
	document.frm.key.value = "";
	document.frm.action = "shop.do?command=" + comm + "&page=1";
	document.frm.submit();
}
/*
function go_total_order(){
	document.frm.key.value = "";
	document.frm.action = "shop.do?command=adminOrderList&page=1";
	document.frm.submit();
}
*/



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



function go_order_save(){
	// 해야할것들
	// #1. 현재 화면에 보여지고 있는 주문들의 체크박스들이 몇개 체크되어 있는지 갯수를 count한다.
	// cart에 담긴 상품들을 지울 떄 count를 사용했다! mypage/mypage.js 참고
	
	// #2. count 값이 0이면 더 진행하지 않고 orderList.jsp로 되돌아가도록 한다.
	
	// #2-1. count 값이 1 이상이라면, 현재 폼안에 있는 체크박스의 벨류값들을 가지고,
	// 처리완료로 처리하기 위해 command=adminOrderSave로 이동시켜 처리한다.
	// 배열로 전송될것이다.
	// (주문의 result 값을 '1' -> '2'로 변경)
	
	// #3. 처리한 뒤에는 orderList.jsp로 되돌아오게 한다.
	
	
	var count = 0;
	if(document.frm.result.length == undefined){	// 화면에 표시된 체크박스가 1개일 경우! 
		// 체크박스가 1개인데 length를 쓰면 undefine이 된다. 따라서 위의 조건을 사용하면 1개 체크되어있을 때를 걸러낼 수 있다.
		if(document.frm.result.checked == true){
			count++;
		}
	}else{	// 회면에 표시된 체크박스가 2개 이상인 경우
		for(var i=0; i<document.frm.result.length;i++){
			if(document.frm.result[i].checked == true)
			count++;
		}
	}
	
	// count값이 0이면, 더이상 진행하지 않고 orderList.jsp로 되돌아간다.
	if(count==0){
		alert("주문처리할 항목을 선택해주세요.");
		return;	// 어차피 if문은 윗 코드에서 끝나므로 return; 을 쓸 필요는 없다.
	}else{	// count 값이 1 이상이면 현재 폼안에 있는 체크박스 벨류값들을 가지고, 처리완료로 처리하러 command=adminOrderSave로 간다.
		document.frm.action = "shop.do?command=adminOrderSave";
		document.frm.submit();
	}
}



function go_view(qseq){
	location.href="shop.do?command=adminQnaDetail&qseq=" + qseq;
}



function go_rep(qseq){
	document.frm.action="shop.do?command=adminQnaReqSave";
	document.frm.submit();
	// 답변 글 등록 & rep 필드를 1에서 2로 업데이트 하는 동작
}