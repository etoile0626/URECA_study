package com.mysite.sbb.question;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuestionServiceTest {

	@Autowired
	private QuestionService questionService;

	@Test
	void test() {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("Test Data : [%03d]", i);
			String content = "This is Test and Test...";
			this.questionService.create(subject, content);
		} // for

	} // test

} // class
