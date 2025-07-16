package me.dohoon.repository;

import me.dohoon.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
