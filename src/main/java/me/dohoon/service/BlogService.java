package me.dohoon.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.dohoon.domain.Article;
import me.dohoon.dto.AddArticleRequest;
import me.dohoon.dto.UpdateArticleRequest;
import me.dohoon.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //저장 로직
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
    
    //전부 검색
    public List<Article> findAll(){
        return blogRepository.findAll();
    }
    
    //특정 값 검색
    public Article findById(long id) {
        Optional<Article> optionalArticle = blogRepository.findById(id);

        if (optionalArticle.isPresent()) {
            return optionalArticle.get(); // 값이 있으면 반환
        } else {
            throw new IllegalArgumentException("not found: " + id); // 없으면 예외
        }
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));

        article.update(request.getTitle(),request.getContent());

        return article;
    }


}
