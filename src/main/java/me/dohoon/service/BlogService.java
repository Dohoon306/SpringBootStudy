package me.dohoon.service;

import lombok.RequiredArgsConstructor;
import me.dohoon.domain.Article;
import me.dohoon.dto.AddArticleRequest;
import me.dohoon.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
