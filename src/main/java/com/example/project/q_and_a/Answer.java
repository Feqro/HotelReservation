package com.example.project.q_and_a;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Answer {

	
	@Id
	private String id;
	@Column(length = 100)
	private String title;
	@Column(length = 2000)
	private String content;
	@CreatedDate
	private LocalDateTime createDate;
	
	@OneToOne		//Many(one)ToOne(Many): 앞이 자신 뒤가 상대. 즉 여기선 답변하나에 여러개의 질문이 달린다는 의미
	@Transient
	private Question question;
}
