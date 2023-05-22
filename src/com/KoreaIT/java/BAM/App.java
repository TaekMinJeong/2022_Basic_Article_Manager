package com.KoreaIT.java.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.BAM.controller.ArticleController;
import com.KoreaIT.java.BAM.controller.Controller;
import com.KoreaIT.java.BAM.controller.MemberController;
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
		
		MemberController memberController = new MemberController(members, sc);
		ArticleController articleController = new ArticleController(articles, sc);
		
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
			
			String[] cmdBits = cmd.split(" ");		//	article list
			
			//	article
			//	이런식으로 하나만 들어오는 경우
			if(cmdBits.length == 1) {
				System.out.println("명령어를 확인해주세요");
				continue;
			}
			
			String controllerName = cmdBits[0];		//	article
			String methodName = cmdBits[1];			//	list
			Controller controller = null;
			
			if(controllerName.equals("article")) {
				controller = articleController;
			}else if(controllerName.equals("member")) {
				controller = memberController;
			}else {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}
			
			controller.doAction(cmd, methodName);
			
//			if(cmd.startsWith("article list")){
//				articleController.showList(cmd);
//			}else if(cmd.equals("article write")){
//				articleController.doJoin();
//			}else if(cmd.equals("member join")){
//				memberController.doJoin();
//			}else if(cmd.startsWith("article detail ")) {
//				articleController.showDetail(cmd);
//			}else if(cmd.startsWith("article modify ")) {
//				articleController.doModify(cmd);
//			}else {
//				System.out.println("존재하지 않는 명령어입니다.");
//			}
		}
		
		System.out.println("== 프로그램 종료 ==");
		
		sc.close();
	}

	private void makeTestData() {
		System.out.println("테스트를 위한 게시물 데이터를 생성합니다.");
		articles.add(new Article(1, Util.getNowDateStr(), "제목1", "내용1", 10));
		articles.add(new Article(2, Util.getNowDateStr(), "제목2", "내용2", 20));
		articles.add(new Article(3, Util.getNowDateStr(), "제목3", "내용3", 55));
	}
}
