package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	public Page<Question> findAll(Pageable pageable);

	public Question findBySubject(String subject);

	public Question findBySubjectAndContent(String subject, String content);

	public List<Question> findBySubjectLike(String subject);

	public List<Question> findBySubjectIn(String[] subject);

} // interface
