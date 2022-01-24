package com.ezenac.util;

public class Paging {
	private int page = 1;		// 현재 화면에 표시될 페이지 번호
	private int totalCount;		// 게시물의 총 갯수
	private int beginPage;		// prev와 next 버튼 사이에 표시될 시작 페이지
	private int endPage;		// prev와 next 버튼 사이에 표시될 끝 페이지
	private int displayRow = 10;	// 한 화면에 표시될 게시물의 갯수
	private int displayPage = 10;	// prev와 next 버튼 사이의 한 화면에 표시될 페이지의 갯수
	boolean prev;				// 화면에 안 보이는 이전페이지로 이동하는 버튼
	boolean next;					// 화면에 안 보이는 다음페이지로 이동하는 버튼
	private int startNum;		// 화면에 표시되는 게시물의 시작 번호(num, pseq 같은 번호가 아닌 rownum)
	private int endNum;		// 화면에 표시되는 게시물의 끝번호(num, pseq 같은 번호가 아닌 rownum)
	
	
	private void paging() {
		endPage = ((int)Math.ceil(page/(double)displayPage))*displayPage;
		beginPage = endPage - (displayPage - 1);
		int totalPage = (int)Math.ceil(totalCount/(double)displayRow);
		if(totalPage<endPage) {
			endPage = totalPage;
			next = false;
		}else {
			next = true;
		}
		prev = (beginPage==1)?false:true;
		startNum = (page-1)*displayRow+1;
		endNum = page*displayRow;
		
		// 아래 코드는 개발 도중에만 사용할 확인용 코드. 정상 작동하면 주석처리하자.
		System.out.println(beginPage + " " + endPage + " " + startNum + " " + endNum + " " + totalCount);
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
		paging();	// 총게시물의 갯수가 totalCount 변수에 셋팅될 때, 나머지 변수값이 계산되도록 paging() 메소드를 호출한다!
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
