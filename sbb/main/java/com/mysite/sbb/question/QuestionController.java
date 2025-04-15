package com.mysite.sbb.question;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.mysite.sbb.answer.AnswerForm;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page
						, @RequestParam(value = "kw", defaultValue = "") String kw) {
		Page<Question> paging = this.questionService.getList(page, kw);
		model.addAttribute("kw", kw);
		return "question_list";
	}

    
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
    	Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
    
    @PreAuthorize("isAuthenticated()")		//로그인 한 경우에만 실행되도록
    @GetMapping("/create")				
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }
    
    @PreAuthorize("isAuthenticated()")		//로그인 한 경우에만 실행되도록
    @PostMapping("/create")		//위 메소드랑 url이 같은데? => http 메서드가 달라서 괜찮음!! 알아서 매핑해줌
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult
    							, Principal principal) {
        if (bindingResult.hasErrors()) {							//이름이 같으면 데이터 바인딩을 해서 여기에 넣어줌
            return "question_form";
        }
        
        SiteUser siteUser = this.userService.getUser(principal.getName());
        
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal) {
    	Question question = this.questionService.getQuestion(id);
    	
    	if(!question.getAuthor().getUsername().equals(principal.getName())) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
    	}
    	questionForm.setSubject(question.getSubject());
    	questionForm.setContent(question.getContent());
    	
    	return "question_form";		//결국 이 화면을 호출할 건데 questionModify를 저장하면서 넘겨주다 보니 questionform을 가지고 있어야함?
    }		
    
    @PostMapping("/modufy")
    public String questionModify(@Valid QuestionForm questionForm
    							, BindingResult bindingResult
    							, @PathVariable("id") Integer id
    							, Principal principal) {
    	
    	if(bindingResult.hasErrors()) return "question_form";
    	
    	Question question = this.questionService.getQuestion(id);
    	
    	if(!question.getAuthor().getUsername().equals(principal.getName())) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
    	}
    	
    	this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
    	
    	return String.format("redirect:/question/detail/%s", id);
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String questionDelete(Principal principal, @PathVariable("id") Integer id) {
    	Question question = this.questionService.getQuestion(id);
    	
    	if(!question.getAuthor().getUsername().equals(principal.getName())) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
    	}
    	this.questionService.delete(question);
    	
    	return "redirect:/";
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
    public String questionVote(Principal principal, @PathVariable("id") Integer id) {
    	
    	Question question = this.questionService.getQuestion(id);
    	
    	SiteUser siteUser = this.userService.getUser(principal.getName());
    	
    	this.questionService.vote(question, siteUser);
    	
    	return String.format("redirect:question/detail/%s", id);
    }
}
