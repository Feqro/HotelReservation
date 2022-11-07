package com.example.project.q_and_a;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {//question 넘기고 주키는 integer타입이다
	List<Question> findByTitle(String title);
	Question findByTitleAndContent(String title, String content);
	
}
