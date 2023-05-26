package com.KoreaIT.java.BAM.dto;

public class Article extends Dto{
	public String title;
	public String body;
	public int viewCnt;
	public int memberId;
	
	public Article(int id, String regDate, int memberId, String title, String body){
		this(id, regDate, memberId, title, body, 0);
	}
	
	public Article(int id, String regDate, int memberId, String title, String body, int viewCnt) {
		this.id = id;
		this.title = title;
		this.memberId = memberId;
		this.body = body;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}

	public void addViewCnt() {
		this.viewCnt++;
	}
}
