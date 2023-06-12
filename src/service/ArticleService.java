package service;

import java.util.List;

import com.KoreaIT.java.BAM.container.Container;
import com.KoreaIT.java.BAM.dao.ArticleDao;
import com.KoreaIT.java.BAM.dto.Article;

public class ArticleService {
	private ArticleDao articleDao;
	
	public ArticleService(){
		this.articleDao = Container.articleDao;
	}
	
	public List<Article> getForPrintArticles(String searchKeyword) {
		return articleDao.getForPrintArticles(searchKeyword);
	}

	public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}

	public void remove(Article foundArticle) {
		articleDao.remove(foundArticle);
	}

	public void add(Article article) {
		articleDao.add(article);
	}

	public int getNewId() {
		return articleDao.getNewId();
	}
	
}
