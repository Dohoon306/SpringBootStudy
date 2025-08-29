package me.dohoon.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Article {
    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",updatable=false)
    private Long id;

    @Getter
    @Column(name="title",nullable=false)
    private String title;

    @Getter
    @Column(name="content",nullable=false)
    private String content;

    @Builder
    public Article(String title, String content){
        this.title=title;
        this.content=content;
    }

    protected Article(){
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    //엔티티에 생성, 수정시간 추가하기
    @CreatedDate//엔티티가 생성될 때 생성 시간 저장
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate//엔티티가 수정될 때 수정 시간 저장
    @Column(name="updated_at")
    private LocalDateTime updatedAt;



}
