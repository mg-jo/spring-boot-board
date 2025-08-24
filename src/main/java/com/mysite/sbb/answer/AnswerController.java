package com.mysite.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer") // 프리픽스
@RequiredArgsConstructor // final이 붙은 필드의 생성자를 자동으로 생성 
@Controller // 서버에 전달된 클라이언트의 요청을 처리하는 클래스
public class AnswerController {

	private final QuestionService questionService;
	private final AnswerService answerService;

	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm,
			BindingResult bindingResult) {
		Question question = this.questionService.getQuestion(id);
		if (bindingResult.hasErrors()) {
			model.addAttribute("question", question); 
			// 뷰를 다시 렌더링할 때,템플릿에서 Question 객체를 요구함
			return "question_detail"; // 에러 시, 기존 입력값, 기존 질문 정보를 그래도 다시 보여줌 (단순 뷰 렌더링)
		}
		this.answerService.create(question, answerForm.getContent());
		return String.format("redirect:/question/detail/%s", id); // 성공 시, 정상적으로 저장 후, 세로운 페이지를 요청 (새로고침)
	}

	
}
