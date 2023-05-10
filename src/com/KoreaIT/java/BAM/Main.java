//	아래의 패키지로 이동 시킴
package com.KoreaIT.java.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		
		//	입력 받기 위한 준비
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.printf("명령어 : ");
			String cmd = sc.nextLine();
			
			if(cmd.equals("exit")) {
				break;
			}
		}
		
		System.out.println("== 프로그램 종료 ==");
		
		sc.close();
	}
}