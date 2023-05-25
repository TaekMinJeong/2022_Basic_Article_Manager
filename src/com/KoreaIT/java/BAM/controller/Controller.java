package com.KoreaIT.java.BAM.controller;

import com.KoreaIT.java.BAM.dto.Member;

public abstract class Controller {
	
	public static Member loginedMember;
	
	public boolean isLogined() {
		return loginedMember != null;
	}
	
	//	추상 메서드는 함수만 만들어놓고 구현 할 필요 없음
	public abstract void doAction(String cmd, String methodName);
	
	public abstract void makeTestData();
}
