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
				System.out.println("게시물이 없습니다");
			}else if(cmd.equals("article write")){
				System.out.println("제목 : ");
				String title = sc.nextLine();
				System.out.println("내용 : ");
				String body = sc.nextLine();
				
				lastArticleID++;
				
				Article article = new Article(lastArticleID, title, body);
				
				System.out.printf("%d번 글이 생성되었습니다\n", lastArticleID);
				
				System.out.printf("%s, %s\n", title, body);
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