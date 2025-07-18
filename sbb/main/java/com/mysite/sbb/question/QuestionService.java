package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	private Specification<Question> search(String kw){
		return new Specification<>() {
			private static final long serialVersionUID = 1L; //나중에 원본 객체 확인용?

			@Override
			public Predicate toPredicate(Root<Question> q, CriteriaQuery<?> query
										, CriteriaBuilder cb) {
				query.distinct(true); //중복 제거
													//뭘 기준으로,  어떤 타입으로 조인할 것인지	
				Join<Question, SiteUser> u1 = q.join("author", JoinType.LEFT);	 //left join할거라 왼쪽에 누가 올지가 중요함
				Join<Question, Answer> a = q.join("answerList", JoinType.LEFT);
				Join<Answer, SiteUser> u2 = q.join("author", JoinType.LEFT);
			
				return cb.or(
							cb.like(q.get("subject"), "%"+kw+"%")	//제목을 kw를 가지고 like 검색
							, cb.like(q.get("content"), "%"+kw+"%")		//내용
							, cb.like(u1.get("username"), "%"+kw+"%")	//질문 작성자
							, cb.like(a.get("content"), "%"+kw+"%")		//답변 내용
							, cb.like(u2.get("username"), "%"+kw+"%")	//답변 작성자
						);
			}
			
		};
	}
	
	/* 아래 페이지 객체 반환 메소드로 변경됨
	public List<Question> getList() {
        return this.questionRepository.findAll();
    }
	*/
	
	public Page<Question> getList(int page, String kw) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        Specification<Question> spec = search(kw);
        return this.questionRepository.findAll(spec, pageable);
    }
	
	public Question getQuestion(Integer id) {  
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {		//question의 값이 null인지 아닌지 확인
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
	
	public void create(String subject, String content, SiteUser user) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }

	public void modify(Question question, String subject, String content) {
		question.setSubject(subject);
		question.setContent(content);
		question.setModifyDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}
	
	public void delete(Question question) {
		this.questionRepository.delete(question);
	}

	public void vote(Question question, SiteUser siteUser) {
		question.getVoter().add(siteUser);
        this.questionRepository.save(question);
	}

}
