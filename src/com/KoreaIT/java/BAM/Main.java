//	아래의 패키지로 이동 시킴
package com.KoreaIT.java.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		
		//	입력 받기 위한 준비
		Scanner sc = new Scanner(System.in);
		
		int lastArticleID = 0;
		
		List<Article> articles = new ArrayList<>();
		
		while(true) {			
			System.out.printf("명령어 : ");
			String cmd = sc.nextLine();
			
			if(cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			if(cmd.equals("exit")) {
				break;
			}
			
			if(cmd.equals("article list")){
				if(articles.size() == 0) {
					continue;
				}
				
				System.out.println("번호	|	제목");
				
				for(int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					
					System.out.printf("%d	|	%s\n", article.id, article.title);
				}
				
			}else if(cmd.equals("article write")){
				System.out.println("제목 : ");
				String title = sc.nextLine();
				System.out.println("내용 : ");
				String body = sc.nextLine();
				
				lastArticleID++;
				
				Article article = new Article(lastArticleID, title, body);
				
				articles.add(article);
				
				System.out.printf("%s번 글이 생성되었습니다\n", lastArticleID);
				
				System.out.printf("%s, %s\n", title, body);
			}else if(cmd.startsWith("article detail ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				boolean found = false;
				
				for(int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					
					if(article.id == id) {
						found = true;
						System.out.printf("%d번 게시물은 존재합니다.\n", id);
					}
				}
				
				if(found == false) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
			}else {
				System.out.println("존재하지 않는 명령어입니다.");
			}
		}
		
		System.out.println("== 프로그램 종료 ==");
		
		sc.close();
	}
}

class Article{
	int id;
	String title;
	String body;
	
	Article(int id, String title, String body){
		this.id = id;
		this.title = title;
		this.body = body;
	}
}