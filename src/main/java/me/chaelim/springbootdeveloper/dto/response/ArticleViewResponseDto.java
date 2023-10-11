package me.chaelim.springbootdeveloper.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.chaelim.springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArticleViewResponseDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public ArticleViewResponseDto(Article article){
        this.id = article.getId();
        this.author = article.getAuthor();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
    }
}
