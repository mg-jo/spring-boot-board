package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final로 선언된 필드의 생성자를 자동으로 생성
@Service // 데이터 처리를 위한 클래스 (컨트롤러 또는 타임리프에서 직접 엔티티 객체를 사용하면 데이터 노출 위험)
public class QuestionService {

	private final QuestionRepository questionRepository;

	public List<Question> getList() {
		return this.questionRepository.findAll();
	}

	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id); 
		// Optional : 값이 존재하는지 확인하는 클래스
		if (question.isPresent()) { // 값이 존재할 경우
			return question.get(); // 값을 꺼냄 (get())
		} else {
			throw new DataNotFoundException("question not found");
		}
	}

	public void create(String subject, String content) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
}
