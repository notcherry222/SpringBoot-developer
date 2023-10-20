package me.chaelim.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.chaelim.springbootdeveloper.domain.Article;
import me.chaelim.springbootdeveloper.dto.response.ArticleListViewResponseDto;
import me.chaelim.springbootdeveloper.dto.response.ArticleViewResponseDto;
import me.chaelim.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    //글 목록 조회
    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponseDto> articles = blogService.findAll().stream()
                .map(ArticleListViewResponseDto::new)
                .toList();

        model.addAttribute("articles", articles);

        return "articleList"; // articles.html 뷰 조회
    }

    //하나의 포스트 조회 ('보러 가기' 클릭 후)
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponseDto(article));

        return "article";
    }

    //수정화면을 보여주기 위한 컨트롤러
    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model){
        if(id == null){
            model.addAttribute("article", new ArticleViewResponseDto());
        } else{
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponseDto(article));
        }
        return "newArticle";
    }
}
