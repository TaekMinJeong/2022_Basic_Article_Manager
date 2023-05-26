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
	
	public void run() {
		System.out.println("== 프로그램 시작 ==");
		
		//	입력 받기 위한 준비
		Scanner sc = new Scanner(System.in);
		
		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
		
		//	테스트 데이터 생성
		articleController.makeTestData();
		memberController.makeTestData();
		
		while(true) {			
			System.out.printf("명령어) ");
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
			
//			String actionName = controllerName + "/" + methodName;
			
			switch(methodName) {
			case "write":
			case "modify":
			case "delete":
			case "logout":
			case "profile":
				if(Controller.isLogined() == false) {
					System.out.println("로그인 후 이용해주세요.");
					continue;
				}
				break;
			case "login":
			case "join":
				if(Controller.isLogined()) {
					System.out.println("로그아웃 후 이용해주세요.");
					continue;
				}
				break;
			}
			
			controller.doAction(cmd, methodName);
		}
		
		System.out.println("== 프로그램 종료 ==");
		
		sc.close();
	}
}
