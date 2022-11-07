package com.example.project.q_and_a;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller// http 통신하는 창구
public class QuestionController {

	private final QuestionService questionService;
	private final QuestionRepository questionRepository;
				
	
	
	
	@RequestMapping("/list")
	//@ResponseBody
	
	public String list(Model model) {
		
		String stateText;
		List<Question> questionList = 
				this.questionService.getList();
		if (questionList != null) {
			stateText =  "검색한 자료있음";
		} else {
			stateText = "검색한 자료가 없습니다.!";
			
		}
		
		model.addAttribute("questionList",questionList);
		model.addAttribute("stateText", stateText);
		
		
		return "q_and_a/question_list";
	}
	
	@RequestMapping("/create")
	public String create() {
		
		this.questionService.create();
		//추가저장작업이 완료되었으면 리스트로 감
		return "redirect:/question/list";
	}
	
	@RequestMapping(value="/detail/{id}")
	public String detail(Model model, @PathVariable("id")Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question",question);
		return "q_and_a/question_detail";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll() {
		List<Question> qList = this.questionRepository.findAll();
		String msg = "";
		
		msg+= "question findAll 검색 자료수 = "+qList.size()+ "<br>";
		
		return msg;
	}
	
	@RequestMapping("/findAllSubject")
	@ResponseBody
	public String findAllSubject() {
		List<Question> qList = this.questionRepository.findAll();
		String result = "";
		for(int i= 0 ; i<qList.size();i++) {
		Question q = qList.get(i);
		result += ""+q.getId()+"}"+q.getTitle()+"<br>";
		}
		return result;
		
	}
	
	@RequestMapping(value="/findAllContent", method=RequestMethod.GET)
	@ResponseBody
	
	public String findAllContent() {
		
		int total_record = 0 ;
		String trEachRecode = "";
		// 레포지토리에서 전체 레코드 가져오기
		List<Question> qList =this.questionRepository.findAll();
		
		for(int i = 0; i< qList.size();i++) {
			Question q = qList.get(i);
			trEachRecode +="<tr>";
			trEachRecode +="<td>"+q.getId()+"</td>";
			trEachRecode +="<td>"+q.getTitle()+"</td>";
			trEachRecode +="<td>"+q.getContent()+"</td>";
			trEachRecode +="</tr>";			
		}
		String html= """
				<html>
				<table border="1">
					<tr>
						<tdcolspan="3">
							
						</td>
					</tr>
					%s
				</table>
				</html>
				""".formatted(trEachRecode);// %s 자리에 삽입
		
		
		log.info("----------------");
		log.info("8888888888888888");
		log.info("================");
		
		
		
		
		
		return html;
		
	}
	
	
	
	@RequestMapping("/listtype")
	@ResponseBody
	
	public String listtype() {
		ArrayList<String> pitches = new ArrayList();
		pitches.add("138");
		pitches.add("129");
		pitches.add("142");
		
		log.info("--------------");
		for(int i = 0 ; i<pitches.size();i++) {
			log.info("pitch{"+"}] ="+pitches.get(i));
		}
		for(String pitch : pitches) {
			log.info("pitch: = "+pitch);
		}
		
		log.info("##############");
		
		return "리스트 데이터 추가";
		
	}

	@RequestMapping("/addFloatList")
	@ResponseBody
	
	public String addFlostList() {
		String result = "";
		List<Float> floatList = new ArrayList<Float>();
		floatList.add(100.0f);
		floatList.add(200.0f);
		floatList.add(300.0f);
		
		floatList.remove(200.0f);
		
		floatList.add(400.0f);
		
		log.info("현재 자료수 : "+floatList.size());
		for(float item : floatList) {
			log.info("아이템 : "+item);
		}
		
		
		
		return result;
	}
	
	@RequestMapping("/insertQuestion")
	@ResponseBody
	public String insertQuestion() {
		Question q1 = new Question();
		q1.setTitle("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고싶어요");
		q1.setCreateDate(LocalDateTime.now());
		
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setTitle("스프링 부트 모델 질문입니다");
		q2.setContent("ID 는 자동 입력 되나요");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
		
		//List<Question> all = this.questionRepository.findAll();
		//int allSize = all.size();
		
		//String msg = "Question 테이블의 총 자료수 : "+allSize;
		
		//return msg;
		return "redirect:/q_and_a/question/getQuestionCount";
	}
	
	@RequestMapping("/getQuestionCount")
	@ResponseBody
	public String getQuestionCount() {
		List<Question> all = this.questionRepository.findAll();
		int allSize = all.size();
		
		return "Question 테이블의 자료수 ="+allSize;
	}
	
	
	@RequestMapping("/findById")
	@ResponseBody
	public String findById() {
		Optional<Question> oq = this.questionRepository.findById(40);
		
		String subject = "";
		if(oq.isPresent()) {
			Question q = oq.get();
			subject = q.getTitle();
		}
		
		return"책 제목은 : "+subject;
	}
	
	@RequestMapping("/findBySubject")
	@ResponseBody
	public String findBySubject() {
		List<Question> q = this.questionRepository.findByTitle("sbb가 무엇인가요?");
		return q.toString();				
	}
	
	@RequestMapping("/findBySubjectAndContent")
	@ResponseBody
	public String findBySubjectAndContent() {
		String subject ="sbb가 무엇인가요?";
		String content = "sbb에 대해서 알고싶어요";
		Question q = 
				this.questionRepository
					.findByTitleAndContent(subject,content);
		String msg = "";
		if(q != null) {
			msg = q.getTitle()+"<br>"+q.getContent();
		}
		return msg;
	}
	
	
	
	
}