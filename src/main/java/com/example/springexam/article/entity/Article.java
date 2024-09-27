package com.example.springexam.article.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Long id;
    private String title;
    private String body;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;
        private String title;
        private String body;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Article build() {
            Article article = new Article();
            article.setId(id);
            article.setTitle(title);
            article.setBody(body);

            return article;
        }
    }
}
