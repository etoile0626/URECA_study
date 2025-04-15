package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository; 
	
	@Test
	void testQuestionInsert() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("스프링 부트 모델 질문입니다. - sbb");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
		
		List<Question> list = this.questionRepository.findAll();
		assertEquals(2, list.size());
		
		Question q = list.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
		
		Optional<Question> oq = this.questionRepository.findById(1);
		Question q3 = oq.get();
		assertEquals("sbb가 무엇인가요?", q3.getSubject());
		
		Question q4  = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q4.getId());
		
		Question q5 = this.questionRepository.findBySubjectAndContent(
                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, q5.getId());
        
        List<Question> qList = this.questionRepository.findBySubjectLike("%sbb%");
        Question q6 = qList.get(0);
        assertEquals("sbb가 무엇인가요?", q6.getSubject());
        
        Optional<Question> oq2 = this.questionRepository.findById(2); //여기서 이미 db 세션이 끝남(테스트 코드 한정, 실제에선 안 그럼)
        assertTrue(oq2.isPresent());
        Question q7 = oq.get();

        List<Answer> answerList = q7.getAnswerList(); 	//그래서 여기서 answerlist에 접근할 수가 없음
        												//해결책-@Transactional을 통해 메소드 종료까지 db 세션 유지

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
	
	/*
	@Test
	void contextLoads() {
	}
*/
}
