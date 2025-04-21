package kr.co.ureca.blog.dto;

import kr.co.ureca.blog.domain.Article;
import lombok.Getter;

@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;

    private final String content;

    public ArticleListViewResponse(Article article){        //조회를 위한 dto
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
