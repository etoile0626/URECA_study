package kr.co.ureca.blog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //protected 접근 제한자 사용해 생성자 만들기
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "author", nullable = false)
    private String author;

    @CreatedDate        //엔티티가 생성될 때 시간
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate //수정될 때 시간
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder    //빌더 패턴으로 객체 생성
    public Article(String author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
