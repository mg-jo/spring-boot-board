package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter // get-() 메서드 생성
@Setter // set-() 메서드 생성 (앤티티 만들 때에는 사용 권장 x :안전하지 않음, 생성자로만 저장할 수 있게 하는 것이 안전)
@Entity // 데이터베이스 테이블과 매핑되는 클래스
public class Question {
	@Id // 기본키 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가하여 저장
	private Integer id;

	@Column(length = 200) // 속성(테이블의 열)의 세부 설정
	private String subject;

	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate; // 데이터베이스에서는 create_date라는 이름으로 저장됨 (테이블의 열)

	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	// 일대다 관계 (One-> mappedBy, Many-> 아래 필드(리스트)))
	// 질문 하나에 답변이 여러 개
	private List<Answer> answerList;
}
