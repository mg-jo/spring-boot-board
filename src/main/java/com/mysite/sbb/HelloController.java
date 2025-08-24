package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 서버에 전달된 클라이언트의 요청을 처리하는 클래스
public class HelloController {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Spring Boot Board";
	}
}
