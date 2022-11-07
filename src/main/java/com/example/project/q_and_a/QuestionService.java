package com.example.project.q_and_a;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.project.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

//컨트롤러와 레포지사이에서 서로 연결해주는 개념
public class QuestionService {
	private final QuestionRepository questionRepository; 
	
	//실질적인 컨트롤러 대신에 저장소에 데이터를 처리 하기 위한 함수
	
	//모든 데이터를 가져오는 서비스(=기능=함수)
	public List<Question> getList(){
		//return this.questionRepository.findByTitle("이게");
		return this.questionRepository.findAll();
	}
	
	// 제목으로 검색한 결과 가져오기
	public List<Question> findByTitle_ForQuestion(String searchWord){
		//return this.questionRepository.findBySubject("333");
		return this.questionRepository.findByTitle(searchWord);
	}	
	
	//임시 질문등록 추가
	public void create() {
		Question q = new Question();
		q.setTitle("333");
		q.setContent("333333");
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			throw new DataNotFoundException("question not found");
		}
	}
	
	
	
	
}
