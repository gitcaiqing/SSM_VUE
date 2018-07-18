package com.ssmvue.common;

public class Pager {
	protected int pageNo=1; // 当前页码
	protected int pageSize=10; // 页面大小
	protected String sort;//排序字段
	protected String direction;//排序方向  desc|asc
	protected int totalRows = 0; 
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getTotalRows() {return totalRows;}
	public void setTotalRows(int totalRows) {this.totalRows = totalRows;}

	public int getStart(){
		if (pageNo < 1) {
			pageNo = 1;
		}
		return pageNo*pageSize-pageSize;
	}

	@Override
	public String toString() {
		return "Pager [pageNo=" + pageNo + ", pageSize=" + pageSize + ", sort="
				+ sort + ", direction=" + direction + "]";
	}
}
