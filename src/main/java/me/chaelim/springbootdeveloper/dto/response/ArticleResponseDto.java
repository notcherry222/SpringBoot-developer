package me.chaelim.springbootdeveloper.dto.response;

import lombok.Getter;
import me.chaelim.springbootdeveloper.domain.Article;

@Getter
public class ArticleResponseDto {
    private final String title;
    private final String content;

    public ArticleResponseDto(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }

}
