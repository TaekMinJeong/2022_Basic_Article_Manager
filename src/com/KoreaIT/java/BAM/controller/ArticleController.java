package com.KoreaIT.java.BAM.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.BAM.dto.Article;
import com.KoreaIT.java.BAM.util.Util;

public class ArticleController {
	List<Article> articles;
	Scanner sc;
	
	public ArticleController(List<Article> articles, Scanner sc) {
		this.articles = articles;
		this.sc = sc;
	}
	
	public void doJoin() {
		int id = articles.size() + 1;
		String regDate = Util.getNowDateStr();
		
		System.out.println("regDate : " + regDate);
		System.out.println("제목 : ");
		String title = sc.nextLine();
		System.out.println("내용 : ");
		String body = sc.nextLine();
		
		Article article = new Article(id, regDate, title, body);
		
		articles.add(article);
		
		System.out.printf("%s번 글이 생성되었습니다\n", id);
		
		System.out.printf("%s, %s\n", title, body);
	}

	public void showList(String cmd) {
		if(articles.size() == 0) {
			System.out.println("게시글이 없습니다.");
			return;
		}
		
		String searchKeyword = cmd.substring("article list".length()).trim();
		
		//	똑같은 객체를 복사해서 생성함
		List<Article> printArticles = new ArrayList<>(articles);;
		
		//	검색어를 입력한 경우
		if(searchKeyword.length() > 0) {
			System.out.println("검색어 : " + searchKeyword);
			
			printArticles.clear();
			
			for(Article article : articles) {
				if(article.title.contains(searchKeyword)) {
					printArticles.add(article);
				}
			}
			
			if(printArticles.size() == 0) {
				System.out.println("검색결과가 없습니다");
				return;
			}
		}
		
		System.out.println("번호	|	제목	|	날짜				|	조회");
		Collections.reverse(printArticles);
		if(printArticles.size() > 0) {
			for(Article article : printArticles) {
					System.out.printf("%d	|	%s	|	%s		|	%d\n", article.id, article.title, article.regDate, article.viewCnt);
				}
		}
	}

	public void showDetail(String cmd) {
		String[] cmdBits = cmd.split(" ");
		int id = Integer.parseInt(cmdBits[2]);
		
		Article foundArticle = getArticleById(id);
		
		if(foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}
		
		foundArticle.addViewCnt();
		
		System.out.printf("번호 : %d\n", foundArticle.id);
		System.out.printf("날짜 : %s\n", foundArticle.regDate);
		System.out.printf("제목 : %s\n", foundArticle.title);
		System.out.printf("내용 : %s\n", foundArticle.body);
		System.out.printf("조회 : %s\n", foundArticle.viewCnt);
		
	}

	public void doModify(String cmd) {
		String[] cmdBits = cmd.split(" ");
		int id = Integer.parseInt(cmdBits[2]);
		
		Article foundArticle = getArticleById(id);
		
		if(foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}
		
		System.out.printf("수정할 제목 : ");
		String title = sc.nextLine();
		System.out.printf("수정할 내용 : ");
		String body = sc.nextLine();
		
		foundArticle.title = title;
		foundArticle.body = body;
		
		System.out.printf("%d번글이 수정되었습니다.\n", id);
		
	}

	private int getArticleIndexById(int id) {
		int i = 0;
		for(Article article : articles) {
			if(article.id == id) {
				return i;
			}
			
			i++;
		}
		
		return i;
	}
	
	private Article getArticleById(int id) {
		int index = getArticleIndexById(id);
		
		if(index != -1) {
			return articles.get(index);
		}
		
		return null;
	}
}