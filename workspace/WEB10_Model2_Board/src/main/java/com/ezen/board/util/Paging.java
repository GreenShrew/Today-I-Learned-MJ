package com.ezen.board.util;

public class Paging {

	private int page = 1;		// 현재 화면에 표시할 페이지 번호
	private int totalCount;		// 게시물의 전체의 갯수

	private int displayRow = 10;	// 한 페이지에 몇 개의 게시물을 표시할것인가
	private int displayPage = 10;	// 이전(◀)과 다음(▶) 버튼 사이에 몇개의 페이지를 표시할것인가

	private int beginPage;		// 표시될 시작 페이지 번호 1 or 11 or 21 or 31 ...
	private int endPage;		// 표시될 끝 페이지 번호 10 or 20 or 30 or 40 ...

	private boolean prev;		// prev 버튼이 보일건지 안보일건지 (true/false)
	private boolean next;		// next 버튼이 보일건지 안보일건지 (true/false)
	
	private int startNum;		// 현재 페이지에 표시될 게시물 번호의 시작 번호
	private int endNum;		// 현재 페이지에 표시될 게시물 번호의 끝 번호
	
	// 페이지 표시 예
	// 1 2 3 4 [5] 6 7 8 9 10 [next]	- 1 페이지부터 표시 prev 없음
	// [prev] 11 12 13 14 [15] 17 18 19 20 [next]	- 게시물 갯수가 200개 이상인 경우
	// [prev] 11 12 13		- next 없음, 게시물 갯수가 121~129개인 경우
	// 본 클래스는 하나의 게시판에 객체하나를 할당해서 전체 게시물 수에 따라 계산된 페이지의 각 요소들을
	// 각 멤버변수에 저장하고 화면에 표시할 내용을 사용하는 클래스이다.
	private void paging() {
		// 각 멤버변수 값을 셋팅한다.
		
		// 1. beginPage 와 endPage 계산
		double temp = page / (double)displayPage;
		// 현재 1 페이지라면... 1/10->0.1		15 페이지라면... 15/10->1.5		25 페이지라면... 25/10->2.5
		
		temp = Math.ceil(temp);		// 소수점 첫 자리 올림 연산
		// 0.1->1.0		1.5->2.0		2.5 -> 3.0
		
		endPage = (int)(temp*displayPage);		// 소수점 절사 후 화면에 표시할 페이지 숫자를 곱셈
		// 1.0->10		2.0->20	3.0->30
		
		// 위 세 단계를 아래 한줄의 코드로 압축할 수 있다.
		// endPage = ((int)(Math.ceil(page/(double)displayPage)))*displayPage;
		
		beginPage = endPage - displayPage + 1;
		// endPage 가 10 이면 beginPage가 1
		// endPage 가 20 이면 beginPage가 11
		// endPage 가 30 이면 beginPage가 21
		
		// 2. 총 페이지의 갯수 totalPage와 next, prev 계산
		int totalPage = (int)Math.ceil(totalCount/(double)displayRow);
		// 총 게시물 수를 한 화면에 표시할 게시물 수(displayRow)로 나눠서 "총 페이지 갯수"를 계산
		// 108 / 10 -> 10.8 -> 11.0 -> 11 즉, 아래의 페이지 갯수는 11개이다.
		
		// next, prev의 표기 여부를 제작
		if(totalPage < endPage) {		// 총 페이지가 화면에 표시할 끝 페이지보다 작다면
			endPage = totalPage;		// endPage를 총 페이지수로 대체하고
			next = false;		// next 버튼이 사라지도록 false를 넣는다.
		}else {		// endPage 뒤로 페이지가 더 있으니 next를 표시하는것으로 설정
			next = true;
		}
		prev = (beginPage==1)? false : true;		// 시작 페이지가 1인 경우만 표시 안함.
		
		
		// 3. startNum, endNum 계산
		startNum = (page-1)*displayRow+1;
		// 현재 화면의 시작 게시물 번호 - 1page : 1, 2page : 11, 3page : 21 ...
		endNum = page*displayRow;
		// 현재 화면의 끝 게시물 번호 - 10, 20, 30 ...
		
		// 이건 제대로 계산 되었는지 확인차 넣어본 코드이다.
		System.out.println(beginPage + " " + endPage + " " + startNum + " " + endNum);
	}
	
	
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		paging();	// 멤버함수 호출 -> 각 멤버변수 구성요소를 계산해주는 메소드
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	
}
