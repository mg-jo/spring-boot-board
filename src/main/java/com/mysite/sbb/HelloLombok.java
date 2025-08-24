package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final이 붙은 필드의 생성자를 자동으로 생성 
@Getter // getHello(), getLombok() 메서드 자동 생성
public class HelloLombok {
	private final String hello;
	private final int lombok;

	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok("헬로", 5);
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}
}
