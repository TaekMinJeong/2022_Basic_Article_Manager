package com.KoreaIT.java.BAM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.BAM.dto.Article;
import com.KoreaIT.java.BAM.dto.Member;
import com.KoreaIT.java.BAM.util.Util;

public class App {
	private List<Article> articles;
	private List<Member> members;
	App() {
		articles = new ArrayList<>();
		members = new ArrayList<>();
	}
	
	public void run() {
		System.out.println("== 프로그램 시작 ==");
		
		makeTestData();
		
		//	입력 받기 위한 준비
		Scanner sc = new Scanner(System.in);
		
		int lastArticleID = 0;
		
		while(true) {			
			System.out.printf("명령어 : ");
			String cmd = sc.nextLine().trim();
			
			if(cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			if(cmd.equals("exit")) {
				break;
			}
			
			if(cmd.startsWith("article list")){
				
				if(articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
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
						continue;
					}
				}
				
				System.out.println("번호	|	제목	|	날짜				|	조회");
				Collections.reverse(printArticles);
				if(printArticles.size() > 0) {
					for(Article article : printArticles) {
							System.out.printf("%d	|	%s	|	%s		|	%d\n", article.id, article.title, article.regDate, article.viewCnt);
						}
				}
				
			}else if(cmd.equals("article write")){
				int id = lastArticleID + 1;
				lastArticleID = id;
				String regDate = Util.getNowDateStr();
				
				System.out.println("regDate : " + regDate);
				System.out.println("제목 : ");
				String title = sc.nextLine();
				System.out.println("내용 : ");
				String body = sc.nextLine();
				
				Article article = new Article(id, regDate, title, body);
				
				articles.add(article);
				
				System.out.printf("%s번 글이 생성되었습니다\n", lastArticleID);
				
				System.out.printf("%s, %s\n", title, body);
			}else if(cmd.equals("member join")){
				int id = members.size() + 1;
				String regDate = Util.getNowDateStr();
				System.out.printf("로그인 아이디 : ");
				String loginId = sc.nextLine();
				System.out.printf("로그인 비밀번호 : ");
				String loginPw = sc.nextLine();
				System.out.printf("로그인 비밀번호 확인 : ");
				String loginPwChk = sc.nextLine();
				System.out.printf("이름 : ");
				String name = sc.nextLine();
				
				Member member = new Member(id, regDate, loginId, loginPw, name);
				
				members.add(member);
				
				System.out.printf("%s회원님 환영합니다.\n", id);
			}else if(cmd.startsWith("article detail ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				Article foundArticle = getArticleById(id);
				
				if(foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				
				foundArticle.addViewCnt();
				
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("날짜 : %s\n", foundArticle.regDate);
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.body);
				System.out.printf("조회 : %s\n", foundArticle.viewCnt);
				
			}else if(cmd.startsWith("article modify ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				Article foundArticle = getArticleById(id);
				
				if(foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				
				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine();
				System.out.printf("수정할 내용 : ");
				String body = sc.nextLine();
				
				foundArticle.title = title;
				foundArticle.body = body;
				
				System.out.printf("%d번글이 수정되었습니다.\n", id);
			}else {
				System.out.println("존재하지 않는 명령어입니다.");
			}
		}
		
		System.out.println("== 프로그램 종료 ==");
		
		sc.close();
	}
	
	private Article getArticleById(int id) {
		
		for(Article article : articles) {
			if(article.id == id) {
				return article;
			}
		}
		
		return null;
	}

	private void makeTestData() {
		System.out.println("테스트를 위한 게시물 데이터를 생성합니다.");
		articles.add(new Article(1, Util.getNowDateStr(), "제목1", "내용1", 10));
		articles.add(new Article(2, Util.getNowDateStr(), "제목2", "내용2", 20));
		articles.add(new Article(3, Util.getNowDateStr(), "제목3", "내용3", 55));
	}
}
