package com.KoreaIT.java.BAM.container;

import com.KoreaIT.java.BAM.dao.ArticleDao;
import com.KoreaIT.java.BAM.dao.MemberDao;

import service.ArticleService;
import service.MemberService;

public class Container {
	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	public static ArticleService articleService;
	public static MemberService memberService;
	
	static {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
		articleService = new ArticleService();
		memberService = new MemberService();
	}
}
