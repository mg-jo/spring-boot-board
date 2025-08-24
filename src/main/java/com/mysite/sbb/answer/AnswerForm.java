package com.mysite.sbb.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter // get-() 메서드 생성
@Setter // set-() 메서드 생성
public class AnswerForm {
	@NotEmpty(message = "내용은 필수항목입니다.")
	private String content;
}
