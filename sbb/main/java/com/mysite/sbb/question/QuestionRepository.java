package com.mysite.sbb.question;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

	Question findBySubject(String string);

	Question findBySubjectAndContent(String subject, String content);

	List<Question> findBySubjectLike(String string);
	
	public List<Question> findBySubjectIn(String[] subject);
	
	public Page<Question> findAll(Pageable pageable); //page 객체에 담아 findAll 수행
	
	//검색어를 가지고 검색해야해서 Specification도 같이 쓰기
	Page<Question> findAll(Specification<Question> spec, Pageable pageable); 
}
