package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter // get-() 메서드 생성
@Setter // set-() 메서드 생성 (앤티티 만들 때에는 사용 권장 x :안전하지 않음, 생성자로만 저장할 수 있게 하는 것이 안전)
@Entity // 데이터베이스 테이블과 매핑되는 클래스
public class Answer {
	@Id // 기본키 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가
	private Integer id;

	@Column(columnDefinition = "TEXT") // 속성 세부 설정
	private String content;

	private LocalDateTime createDate;

	@ManyToOne // 다대일 관계 (Many-> 클래스, One-> 아래 필드)
	private Question question; // 한 질문에 답변이 여러 개
}
