package com.bw.bean;

public class Brand {
	private Integer bid;
	//sssss
	private String bname;
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	@Override
	public String toString() {
		return "Brand [bid=" + bid + ", bname=" + bname + "]";
	}
	
}
