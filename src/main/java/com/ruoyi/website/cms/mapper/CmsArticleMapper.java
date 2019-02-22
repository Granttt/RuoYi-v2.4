package com.ruoyi.website.cms.mapper;


import com.ruoyi.website.cms.entity.CmsArticle;

import java.util.List;

/**
 * 文章 数据层
 *
 * @author xingyu
 * @date 2019-01-10
 */
public interface CmsArticleMapper {
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
     * @param arg0 起始位置
     * @param arg1 分页大小
     * @return 文章集合
     */
    List<CmsArticle> selectCmsArticlePage(Integer arg0, Integer arg1);

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
     * 删除文章
     *
     * @param id 文章ID
     * @return 结果
     */
    int deleteCmsArticleById(String id);

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteCmsArticleByIds(String[] ids);

    /**
     * 查询总条数
     * @return 总条数
     */
    Integer selectCmsArticleCount();
}