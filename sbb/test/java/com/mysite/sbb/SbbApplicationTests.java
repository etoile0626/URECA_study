package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository; 
	
	/*
	@Test
	void testQuestionInsert() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해 알고 싶어요");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("스프링부트모델 질문입니다");
		q2.setContent("sbb에 대해 알려주세요");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}
	*/
	
	@Test
	void testQuestionList() {
		List<Question> list = this.questionRepository.findAll();
		assertEquals(2, list.size());
		
		Question q = list.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}
	
	/*
	@Test
	void contextLoads() {
	}
*/
}
