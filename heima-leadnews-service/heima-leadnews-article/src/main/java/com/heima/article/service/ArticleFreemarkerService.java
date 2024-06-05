package com.heima.article.service;

import com.heima.model.articles.pojos.ApArticle;

public interface ArticleFreemarkerService {
    public void buildArticleToMinIO(ApArticle apArticle, String content);
}
