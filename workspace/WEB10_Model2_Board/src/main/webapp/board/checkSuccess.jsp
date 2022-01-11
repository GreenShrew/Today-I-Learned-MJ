<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkSuccess</title>
</head>
<body>
<script type="text/javascript">
	if(window.name=='update'){	// 현재 열려있는 팝업창의 name이 update라면
		// num 값을 가지고 아래의 주소로 보낸다.
		window.opener.location.href = "board.do?command=boardUpdateForm&num=${param.num}";
	}else if(window.name=='delete'){	// 현재 열려있는 팝업창의 name이 delete라면
		var bool = confirm("정말로 삭제할까요?");
		if(bool){
			window.opener.location.href = "board.do?command=boardDelete&num=${param.num}";
		} //else{	 사실 페이지가 그대로 열려있기 때문에 이 부분은 없어도 무방하다.
//			window.opener.location.href = "board.do?command=boardViewWithdoutCount&num=${param.num}";
//		}
	}
	self.close();
</script>
</body>
</html>