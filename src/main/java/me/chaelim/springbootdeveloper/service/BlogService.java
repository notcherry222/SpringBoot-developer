package me.chaelim.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.chaelim.springbootdeveloper.domain.Article;
import me.chaelim.springbootdeveloper.dto.request.AddArticleRequestDto;
import me.chaelim.springbootdeveloper.dto.request.UpdateArticleRequestDto;
import me.chaelim.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final, @Nonnull이 붙은 필드의 생성자 추가
@Service // 빈으로 servlet 컨테이너에 등록
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequestDto request, String userName){
        return blogRepository.save(request.toEntity(userName)); // toEntity: 빌더패턴을 사용해 dto를 엔터티로 만들어주는 메서드
    }
    //글 목록 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }
    //글 하나 조회
    public Article findById(long id){
        //JPA에서 제공하는 findById를 사용해 id를 받아 엔터티 조회
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }
    //글 삭제
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    //글 수정
    @Transactional // 매칭한 메소드를 하나의 트랜잭션으로 묶는 역할을 함 ex> 출금과 입금
    public Article update(long id, UpdateArticleRequestDto request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : "+ id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
