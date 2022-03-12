function go_cart(){
	if (document.formm.quantity.value == "") {
	    alert("수량을 입력하여 주세요.");
	    document.formm.quantity.focus();
	}else{
		document.formm.action ="cartInsert";
		document.formm.submit();
	}
}




function go_cart_delete(){
	
	var count = 0;  	
	if(document.formm.cseq.length==undefined){   
		if( document.formm.cseq.checked == true )
			count++;
	}else{  // 체크박스가 두개 이상일때
		for( var i=0; i< document.formm.cseq.length ; i++){
			if( document.formm.cseq[i].checked == true )
				count++;
		}
	}	
	
	if( count == 0 ){
		alert("삭제할 항목을 선택해주세요");
	} else{
		document.formm.action = "cartDelete";
	    document.formm.submit();
	}
}



function go_order_insert(){

	document.formm.action ="orderInsert";
	document.formm.submit();
	
}




function go_order(){
	document.formm.action = "orderOne";
	document.formm.submit();
}







function withdrawalConfirm(){
	var answer = confirm("회원탈퇴를하면 장바구니 및 이용내역이 모두 없어집니다. 탈퇴하시겠습니까?");
	if( answer ){
		location.href="shop.do?command=Withdrawal";
	}
}

















