package me.chaelim.springbootdeveloper.controller.blog;

import lombok.RequiredArgsConstructor;
import me.chaelim.springbootdeveloper.domain.Article;
import me.chaelim.springbootdeveloper.dto.request.AddArticleRequestDto;
import me.chaelim.springbootdeveloper.dto.request.UpdateArticleRequestDto;
import me.chaelim.springbootdeveloper.dto.response.ArticleResponseDto;
import me.chaelim.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequestDto request, Principal principal){
        Article savedArticle = blogService.save(request, principal.getName());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponseDto>> findAllArticles() {
        List<ArticleResponseDto> articles = blogService.findAll()
                .stream()
                .map(ArticleResponseDto::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    //URL 경로에서 값 추출
    public ResponseEntity<ArticleResponseDto> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponseDto(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequestDto request) {
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
}
