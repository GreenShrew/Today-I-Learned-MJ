<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07_Calendar</title>
<style type="text/css">
	td{font-weight:bold; font-size:110%;}
	tr>td:first-child{color:red;}
	tr>td:last-child{color:blue;}
</style>
</head>
<body>
<%
// java.util.Calendar sDay = java.util.Calendar.getInstance();	위에서 @page import="java.util.Calendar"와 같이 import할 수 있다.
Calendar sDay = Calendar.getInstance();	// 출력될 시작 날자 저장객체
Calendar eDay = Calendar.getInstance();	// 출력될 끝 날자 저장객체

int sYear = sDay.get(Calendar.YEAR);		// 오늘 날자의 연도
int sMonth = sDay.get(Calendar.MONTH);		// 오늘 날자의 월(0~11의 값으로 유지, 마지막에 +1을 계산하여 출력한다)

// 이전달, 다음달 버튼을 만들었을 때...
// 버튼을 누르면 전달되어진 sYear과 sMonth가 해당 값으로 들어간다.
if(request.getParameter("sYear")!=null) sYear = Integer.parseInt(request.getParameter("sYear"));
if(request.getParameter("sMonth")!=null) {
	sYear = Integer.parseInt(request.getParameter("sMonth"));
	if(sMonth==12){
		sMonth=0;
		sYear++;
	}
	if(sMonth==-1){
		sMonth=11;
		sYear--;
	}
}


// 현재 날짜에 해당하는 월의 1일로 sDay를 설정한다.
sDay.set(sYear, sMonth, 1);	// 2021-12-01
// eDay는 현재 날짜의 다음달 1일로 셋팅 후 1일을 빼서 이번달 마지막날로 셋팅
eDay.set(sYear, sMonth+1, 1);	// 다음달 1일
eDay.add(Calendar.DATE, -1);	// 이번달 말일

// 출력하려는 월의 1일자가 무슨 요일인지 정수값으로 계산 <- 1:일요일, 2:월요일...
int START_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

int i, k, cnt=0;	// i는 반복실행에 사용, k는 날자 출력에 사용, cnt는 줄바꿈에 사용
%>

<h1><a href="07_Calendar.jsp?sYear=<%=sYear%>&sMonth=<%=sMonth-1%>">이전달</a> &nbsp;&nbsp;&nbsp; <%=sYear %>년 <%=sMonth+1 %>월 &nbsp;&nbsp;&nbsp;
<a href="07_Calendar.jsp?sYear=<%=sYear%>&sMonth=<%=sMonth+1%>">다음달</a></h1>
<table width="560" align="left" cellspacing="1" bgcolor="black">
	<tr bgcolor="white" height="50">
		<td align="center" width="80">일</td>
		<td align="center" width="80">월</td>
		<td align="center" width="80">화</td>
		<td align="center" width="80">수</td>
		<td align="center" width="80">목</td>
		<td align="center" width="80">금</td>
		<td align="center" width="80">토</td>
	</tr>
	
	<!-- 첫줄에 나올 날짜들 - 1일차 요일 전 까지 공백, 1, 2, 3 ... -->
	<tr bgcolor="white" height="50">
		<%for(i=1; i<START_WEEK; i++){ %>
			<td>&nbsp;</td>	<!-- 첫칸부터 시작날짜의 요일 바로 전열까지 빈칸 표시 -->
		<%} %>
		<%for(i=1; i<=8-START_WEEK; i++){ %>
			<td align="right"><%=i %>&nbsp;</td>		<!-- 1일차부터 토요일까지 날자 표시 -->
		<%} %>
	</tr>
	
	<tr bgcolor="white" height="50">
		<%for(k=i; k<=eDay.get(Calendar.DATE); k++){ %>

			<td align="right"><%=k %>&nbsp;</td>	<!-- 날짜출력 -->

			<%cnt++;
			if(cnt%7==0){%>
				</tr><tr bgcolor="white" height="60">	<!-- tr 태그 끝내고 다시 시작 = 줄바꿈 -->
			<%} %>
		<%} %>
		<%for(i=1; i<=7-(cnt%7); i++) {%>	<!-- 마지막 줄 남은칸 채움 -->
			<td>&nbsp;</td>
		<%} %>
	</tr>

</table>

</body>
</html>