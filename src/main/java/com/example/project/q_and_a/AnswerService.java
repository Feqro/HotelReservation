package com.example.project.q_and_a;


import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.project.q_and_a.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

//컨트롤러와 레포지사이에서 서로 연결해주는 개념
public class AnswerService {
	private final AnswerRepository answerRepository; 
	
	
	//임시 질문등록 추가
	public void create(Question question, String content) {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		
		
		this.answerRepository.save(answer);
	}

	
	
	
}
