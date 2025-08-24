package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/sbb") //URL과 메서드를 매핑
	@ResponseBody // 문자열 그대로 브라우저에 출력
	public String index() {
		return "안녕하세요 sbb에 오신것을 환영합니다.";
	}

	@GetMapping("/") // 루트 URL : 메인 페이지
	public String root() {
		return "redirect:/question/list"; // redirect : 새로운 URL로 전송하는 것
	}
}
