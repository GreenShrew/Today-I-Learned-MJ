function go_cart(){
	if(document.formm.quantity.value == ""){
		alert("수량을 입력하여 주세요.")
		document.formm.quantity.focus();
	}else{
		document.formm.action="shop.do?command=cartInsert";	// 수량 입력했다면 shop.do로 이동시킨다.
		document.formm.submit();
	}
}