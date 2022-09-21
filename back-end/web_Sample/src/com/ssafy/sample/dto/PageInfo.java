package com.ssafy.sample.dto;

public class PageInfo {
	private boolean forward;
	public PageInfo(boolean forward, String page) {
		super();
		this.forward = forward;
		this.page = page;
	}
	private String page;
	public boolean isForward() {
		return forward;
	}
	public void setForward(boolean forward) {
		this.forward = forward;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
}
