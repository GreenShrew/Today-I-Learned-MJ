function go_cart(){
	if(document.formm.quantity.value == ""){
		alert("수량을 입력하여 주세요.")
		document.formm.quantity.focus();
	}else{
		document.formm.action="shop.do?command=cartInsert";	// 수량 입력했다면 shop.do로 이동시킨다.
		document.formm.submit();
	}
}




function go_cart_delete(){
	//document.formm.cseq[]			// 자바스크립트에서 jsp 페이지 내에 있는 같은 name의 두개이상의 입력란들은 모두 배열로 인식된다.
	
	// 그것은 라디오버튼에도 적용되며, 배열로 인식되었다는 말은 그 배열의 length(크기) 속성이 존재하고 이를 사용할 수 있다는 뜻이다.
	
	// 다만, 같은 이름으고 구성된 체크박스 내지는 라디오버튼이 한개라면 그 배열의 length는 undefind 값을 갖는다.
	// 두개 이상이라면 당연히 배열의 갯수를 갖는다.
	
	// 아래 코드는 체크박스(name:cseq)의 갯수가 한개일때와 두개일때를 구분하여 처리하는 코드이다.
	// 각각 체킹된 checkbox가 몆개인지 갯수를 세고, 하나도 체크되지 않았다면 되돌아가는 코드이다.
	
	var count = 0;	// 체크된 체크박스의 갯수를 카운트하기 위한 변수
	
	if(document.formm.cseq.length == undefined){	// 장바구니에 물건이 하나일때, 체크박스가 하나일때
		// 체크박스가 한개라면, 그 체크박스가 체크 되어있는지만 검사해서 count 변수에 1 또는 0을 저장한다.
		if(document.formm.cseq.checked == true)
			count++;	// 혹은 count = 1;
		}else{	// 체크박스가 두개 이상일 때
			for(var i=0; i<document.formm.cseq.length; i++){	// 3개면 0부터 2까지 오르겠지?
				if(document.formm.cseq[i].checked == true)		// 체크된 박스 숫자만큼 count가 증가한다.
					count++;
			}
		}
	if(count==0){
		alert("삭제할 항목을 선택해주세요.");
	}else{
		document.formm.action="shop.do?command=cartDelete";
		document.formm.submit();
	}
}


function go_order_insert(){
	
	document.formm.action = "shop.do?command=orderInsert";
	document.formm.submit();
	
}






function go_order(){
	document.formm.action = "shop.do?command=orderOne";
	document.formm.submit();
}