package com.heima.article.feign;

import com.heima.article.service.ApArticleService;
import com.heima.model.articles.dto.ArticleDto;
import com.heima.model.common.dtos.ResponseResult;
import com.zhouhao.apis.article.IArticleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleClient implements IArticleClient {

    @Autowired
    private ApArticleService apArticleService;

    @Override
    @PostMapping("/api/v1/article/save")
    public ResponseResult saveArticle(@RequestBody ArticleDto dto) {
        return apArticleService.saveArticle(dto);
    }

}