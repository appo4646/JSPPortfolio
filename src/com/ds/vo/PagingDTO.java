package com.ds.vo;

public class PagingDTO {
	public static int PAGE_BLOCK = 10;

	private int pageRow = 6;
	private int nowPage = 1;
	private int startRow = 1;
	private int endRow = pageRow;
	private int startPage = 1;
	private int endPage = PAGE_BLOCK;
	private int totalPage;

	public PagingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagingDTO(int pageRow, int nowPage, int startRow, int endRow, int startPage, int endPage, int totalPage) {
		super();
		this.nowPage = nowPage;
		this.startRow = startRow;
		this.endRow = endRow;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public static int getPAGE_BLOCK() {
		return PAGE_BLOCK;
	}

	public static void setPAGE_BLOCK(int pAGE_BLOCK) {
		PAGE_BLOCK = pAGE_BLOCK;
	}

	public int getPageRow() {
		return pageRow;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage, int totalCount) {
		this.nowPage = nowPage;
		setTotalPage(totalCount);
		startRow = nowPage * pageRow - (pageRow - 1);
		endRow = nowPage * pageRow;
		
		startPage = (nowPage - 1) / PAGE_BLOCK * PAGE_BLOCK + 1;
		endPage = startPage + (PAGE_BLOCK - 1);
		
		if (endPage > totalPage){
			endPage = totalPage;
		}
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalCount) {
		this.totalPage = (totalCount - 1) / pageRow + 1;
	}

	@Override
	public String toString() {
		return "PagingDTO [pageRow=" + pageRow + ", nowPage=" + nowPage + ", startRow=" + startRow + ", endRow="
				+ endRow + ", startPage=" + startPage + ", endPage=" + endPage + ", totalPage=" + totalPage + "]";
	}

}
