package com.mysite.sbb.answer;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;


    public Answer getAnswer(Integer id) {  
        Optional<Answer> answer = this.answerRepository.findById(id);
        if (answer.isPresent()) {		//question의 값이 null인지 아닌지 확인
            return answer.get();
        } else {
            throw new DataNotFoundException("answer not found");
        }
    }
	
	public Answer create(Question question, String content, SiteUser user) {
		Answer a = new Answer();
		a.setQuestion(null);
        a.setContent(content);
        a.setCreateDate(LocalDateTime.now());
        a.setAuthor(user);
        this.answerRepository.save(a);
        
        return a;
    }

	public void modify(Answer answer, String content) {
		answer.setContent(content);
		answer.setModifyDate(LocalDateTime.now());
		this.answerRepository.save(answer);
	}
	
	public void delete(Answer answer) {
		this.answerRepository.delete(answer);
	}
	
	public void vote(Answer answer, SiteUser siteUser) {
        answer.getVoter().add(siteUser);
        this.answerRepository.save(answer);
    }
}
