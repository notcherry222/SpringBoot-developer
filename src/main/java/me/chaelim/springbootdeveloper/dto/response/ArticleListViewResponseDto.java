package me.chaelim.springbootdeveloper.dto.response;

import lombok.Getter;
import me.chaelim.springbootdeveloper.domain.Article;

@Getter
public class ArticleListViewResponseDto {

    private final Long id;
    private final String author;
    private final String title;
    private final String content;

    public ArticleListViewResponseDto(Article article){
        this.id = article.getId();
        this.author = article.getAuthor();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
