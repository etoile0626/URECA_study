package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")		//글자수 제한 없이 텍스트 넣기
    private String content;

    private LocalDateTime createDate;
    
    //하나의 질문에 여러 답변가능, mappedBy로 answer 쪽에서 매핑한 속성 전달, 삭제는 같이 되도록 cascade 설정
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
    private List<Answer> answerList;		//onetomany니까 여러개의 answer들과 매핑하기 위한 리스트
    
    @ManyToOne			//사용자 한 명이 여러개의 질문이 가능하므로 m:1
    private SiteUser author;
    
    private LocalDateTime modifyDate;
    
    @ManyToMany			//여러명의 사용자는 각각 여러명에게 추천이 가능하므로					
    private Set<SiteUser> voter;
    
}
