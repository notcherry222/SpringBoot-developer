package me.chaelim.springbootdeveloper.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.chaelim.springbootdeveloper.domain.Article;

@NoArgsConstructor //기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequestDto {
    private String title;
    private String content;

    public Article toEntity(String author){ // 생성자를 사용해 객체 생성
        return Article.builder()
                .author(author)
                .title(title)
                .content(content)
                .build();
    }
}
