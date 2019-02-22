package com.ruoyi.website.cms.service;


import com.ruoyi.website.cms.entity.CmsArticle;

import java.util.List;

/**
 * 文章 服务层
 *
 * @author xingyu
 * @date 2019-01-10
 */
public interface ICmsArticleService {
    /**
     * 查询文章信息
     *
     * @param id 文章ID
     * @return 文章信息
     */
    CmsArticle selectCmsArticleById(String id);

    /**
     * 查询文章列表
     *
     * @param cmsArticle 文章信息
     * @return 文章集合
     */
    List<CmsArticle> selectCmsArticleList(CmsArticle cmsArticle);

    /**
     * 分页查询文章列表
     *
     * @param begin 起始位置
     * @param size 分页大小
     * @return 文章集合
     */
    List<CmsArticle> selectCmsArticlePage(Integer begin, Integer size);

    /**
     * 新增文章
     *
     * @param cmsArticle 文章信息
     * @return 结果
     */
    int insertCmsArticle(CmsArticle cmsArticle);

    /**
     * 修改文章
     *
     * @param cmsArticle 文章信息
     * @return 结果
     */
    int updateCmsArticle(CmsArticle cmsArticle);

    /**
     * 删除文章信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteCmsArticleByIds(String ids);

    /**
     * 查询总条数
     * @return 结果
     */
    int selectCmsArticleCount();

}
