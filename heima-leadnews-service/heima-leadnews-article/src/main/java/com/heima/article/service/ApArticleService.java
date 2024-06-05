package com.heima.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.articles.dto.ArticleDto;
import com.heima.model.articles.dto.ArticleHomeDto;
import com.heima.model.articles.pojos.ApArticle;
import com.heima.model.common.dtos.ResponseResult;

public interface ApArticleService extends IService<ApArticle> {
    ResponseResult load(Short loadtype, ArticleHomeDto dto);
    /**
     * 保存app端相关文章
     * @param dto
     * @return
     */
    ResponseResult saveArticle(ArticleDto dto) ;
    ResponseResult load2(ArticleHomeDto dto,Short type,boolean firstPage);
}
