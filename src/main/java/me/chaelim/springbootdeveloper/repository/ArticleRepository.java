package me.chaelim.springbootdeveloper.repository;

import me.chaelim.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
