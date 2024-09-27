package com.example.springexam.article.dao;

import com.example.springexam.article.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDao {

    void save(Article article);
    void update(Article article);
    void deleteById(Long id);
    Article findById(Long id);
    List<Article> findAll();

}
