package me.chaelim.springbootdeveloper.repository;

import me.chaelim.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
    //todo: 리팩토링하기
    String findArticleById(Long id);
}
