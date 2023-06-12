package com.KoreaIT.java.BAM.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.BAM.dto.Article;

public class ArticleDao extends Dao{
	private List<Article> articles;
	
	public ArticleDao() {
		articles = new ArrayList<>();
	}

	public void add(Article article) {
		articles.add(article);
		lastId++;
	}

	public List<Article> getForPrintArticles(String searchKeyword) {
		//		검색어를 입력한 경우
		if(searchKeyword != null) {
			System.out.println("검색어 : " + searchKeyword);
			
			List<Article> forPrintArticles = new ArrayList<>();
			
			forPrintArticles.clear();
			
			for(Article article : articles) {
				if(article.title.contains(searchKeyword)) {
					forPrintArticles.add(article);
				}
			}
			return forPrintArticles;
		}
		
		return articles;
	}
}
