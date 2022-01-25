function go_search(){
	if(document.frm.key.value == "") return;
	var url = "shop.do?command=adminProductList&page=1";	// 검색어로 검색한 결과의 1페이지로 이동한다.
	document.frm.action = url;
	document.frm.submit();
}