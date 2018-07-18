package com.ssmvue.common;

import java.util.ArrayList;
import java.util.List;

public class VuePager<T> extends Pager {
	private List<T> list = new ArrayList<T>();

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public VuePager() {
	}

	public VuePager(int totalRows, List<T> list) {
		this.list = list;
		super.totalRows = totalRows;
	}

	@Override
	public String toString() {
		return "VuePager [list=" + list 
				+ ", count=" + super.totalRows
				+ ", pageNo=" + super.pageNo 
				+ ", pageSize=" + super.pageSize 
				+ ", sort=" + super.sort 
				+ ", direction=" + super.direction
				+ "]";
	}
	
}
