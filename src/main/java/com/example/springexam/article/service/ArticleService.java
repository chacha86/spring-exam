package com.example.springexam.article.service;

import com.example.springexam.article.entity.Article;
import com.example.springexam.article.dao.ArticleDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleDao articleDao;

    public void write(String title, String body) {

        Article article = Article.builder()
                .title(title)
                .body(body)
                .build();

        articleDao.save(article);
    }

    public void update(long id, String title, String body) {

        Article article = articleDao.findById(id);

        if (article == null) {
            throw new RuntimeException("not found article");
        }

        article.setTitle(title);
        article.setBody(body);
        articleDao.update(article);
    }

    public void delete(long id) {
        Article article = articleDao.findById(id);
        if (article == null) {
            throw new RuntimeException("not found article");
        }
        articleDao.deleteById(id);
    }

    public List<Article> getAllItems() {
        return articleDao.findAll();
    }

    public Article getItemById(long id) {
        Article article = articleDao.findById(id);
        if(article == null) {
            throw new RuntimeException("not found article");
        }
        return article;
    }
}
