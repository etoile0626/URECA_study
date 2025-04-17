package kr.co.ureca.blog.repository;

import kr.co.ureca.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {


}
