package kr.co.ureca.blog.dto;

import kr.co.ureca.blog.domain.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {
    private final String title;

    private final String content;

    public ArticleResponse(Article article){        //조회를 위한 dto
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
