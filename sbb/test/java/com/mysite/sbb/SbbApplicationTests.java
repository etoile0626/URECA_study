package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void testQuestionInsert() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해 알고 싶어요.");
		q1.setCreateDate( LocalDateTime.now() );
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("스프링 부트 모델 질문 입니다. - sbb");
		q2.setContent("id는 자동 생성되나요?");
		q2.setCreateDate( LocalDateTime.now() );
		this.questionRepository.save(q2);

		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());

		Optional<Question> opQ3 = this.questionRepository.findById(1);
		Question q3 = opQ3.get();
		assertEquals("sbb가 무엇인가요?", q.getSubject());

		Question q4 = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q.getId());

		Question q5 = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해 알고 싶어요.");
		assertEquals(1, q.getId());

		List<Question> qList = this.questionRepository.findBySubjectLike("%sbb%");
		assertEquals(2, qList.size());

		String [] strArr = new String[2];
		strArr[0] = "sbb가 무엇인가요?";
		strArr[1] = "스프링 부트 모델 질문 입니다. - sbb";
		List<Question> qList2 = this.questionRepository.findBySubjectIn(strArr);
		assertEquals(2, qList2.size());

//		Question q6 = this.questionRepository.findById(1).get();
//		q6.setSubject("수정된 제목.");
//		this.questionRepository.save(q6);
//
//		Question q7 = this.questionRepository.findById(1).get();
//		this.questionRepository.delete(q7);

		Question q8 = this.questionRepository.findById(2).get();
		Answer answer = new Answer();
		answer.setContent("네 자동으로 생성됩니다.");
		answer.setQuestion(q8);
		this.answerRepository.save(answer);

		Question q9 = this.questionRepository.findById(2).get();
		List<Answer> list = q9.getAnswerList();
		assertEquals(1, list.size());

	} // testJpa

//	@Test
//	void contextLoads() {
//	}

} // class
