package com.panshi.demo.domain;

public class ConditionVo {
	
	
	private int page;
	private int limit;
	private String name;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ConditionVo [page=" + page + ", limit=" + limit + ", name=" + name + "]";
	}
	
	
}
