package me.dohoon.service;

import lombok.RequiredArgsConstructor;
import me.dohoon.domain.Article;
import me.dohoon.dto.AddArticleRequest;
import me.dohoon.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //저장 로직
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }
}
