package com.mysite.sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;
// 리포지터리 : 데이터베이스의 데이터를 CRUD할 수 있도록 돕는 인터페이스
public interface QuestionRepository extends JpaRepository<Question, Integer> {
// Question 엔티티로 리포지터리를 생성함, 해당 엔티티의 기본키는 Integer임
}
