package com.KoreaIT.java.BAM.dto;

public class Article{
	public int id;
	public String title;
	public String body;
	public String regDate;
	public int viewCnt;
	
	public Article(int id, String regDate, String title, String body){
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
	}
	
	public Article(int id, String regDate, String title, String body, int viewCnt) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}

	public void addViewCnt() {
		this.viewCnt++;
	}
}
