package com.mysite.sbb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter // get-() 메서드 생성
@Setter // set-() 메서드 생성
public class QuestionForm {
	@NotEmpty(message = "제목은 필수항목입니다.") // Null 또는 빈 문자열을 허용하지 않음
	@Size(max = 200) // 문자 길이 제한
	private String subject;

	@NotEmpty(message = "내용은 필수항목입니다.")
	private String content;
}
