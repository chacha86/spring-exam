package com.example.springexam.article.controller;

import com.example.springexam.article.entity.Article;
import com.example.springexam.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article/write")
    @ResponseBody
    public String write(String title, String body) {
        articleService.write(title, body);
        return "게시물이 성공적으로 저장되었습니다.";
    }

    @RequestMapping("/article/modify/{id}")
    @ResponseBody
    public String modify(@PathVariable("id") long id, String title, String body) {
        articleService.update(id, title, body);
        return "게시물이 수정되었습니다.";
    }

    @RequestMapping("/article/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") long id) {
        articleService.delete(id);
        return "게시물이 삭제되었습니다";
    }

    @RequestMapping("/article/list")
    @ResponseBody
    public List<Article> list() {
        return articleService.getAllItems();
    }

    @RequestMapping("/article/detail/{id}")
    @ResponseBody
    public Article detail(@PathVariable("id") long id) {
        return articleService.getItemById(id);
    }

    @GetMapping("/article/write")
    public String showWrite() {
        return "article-write";
    }
}
