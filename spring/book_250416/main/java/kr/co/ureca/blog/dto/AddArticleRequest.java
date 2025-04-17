package kr.co.ureca.blog.dto;

import kr.co.ureca.blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {                //게시글 추가를 위한 dto

    private String title;

    private String content;

    @Builder
    public Article toEntity(){
        return Article.builder()
                      .title(title)
                      .content(content)
                      .build();
    }
}
