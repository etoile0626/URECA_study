package kr.co.ureca.blog.service;

import jakarta.transaction.Transactional;
import kr.co.ureca.blog.domain.Article;
import kr.co.ureca.blog.dto.AddArticleRequest;
import kr.co.ureca.blog.dto.UpdateArticleRequest;
import kr.co.ureca.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("not found: "+id));
                                //id로 찾은 값이 null이면 예외 반환
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
