package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.sbb.answer.AnswerForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/question") // 프리픽스
@RequiredArgsConstructor // final로 선언된 필드의 생성자를 자동으로 생성
@Controller // 서버에 전달된 클라이언트의 요청을 처리하는 클래스
public class QuestionController {

	private final QuestionService questionService;

	@GetMapping("/list")
	public String list(Model model) { // Model : 컨트롤러(서버)에서 템플릿으로 데이터를 전달함
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList); // (템플릿에서 쓰일 이름, ---)
		return "question_list";
	}

	@GetMapping(value = "/detail/{id}") // id 값을 받아 @PathVariable을 통해 매개변수 id에 바인딩(연결)
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}

	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) { 
	// QuestionForm 객체를 자동 생성하여 템플릿으로 전달 (템플릿에서 questionForm 객체를 무조건 필요로 함! 빈 객체더라도)
		return "question_form";
	}

	@PostMapping("/create") 
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
	// 매개변수의 형태가 다르다면 메서드명 중복 가능
	// @Valid : 검증 기능 
	// 매개 변수가 Form 객체로 보이면 해당 객체에서 subject, content 필드명을 찾아 form 데이터인 subject, content과 바인딩함
		if (bindingResult.hasErrors()) {
			return "question_form"; // 에러 시, 다시 form 뷰 렌더링 (오류는 bindingResult->#fields.allErrors()로)
		} 
		this.questionService.create(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list"; // 성공 시, 정상적으로 저장 후 새로운 페이지 요청(새로 고침)
	}
}
