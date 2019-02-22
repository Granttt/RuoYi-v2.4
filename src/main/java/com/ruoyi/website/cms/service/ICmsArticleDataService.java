package com.ruoyi.website.cms.service;


import com.ruoyi.website.cms.entity.CmsArticle;
import com.ruoyi.website.cms.entity.CmsArticleData;

import java.util.List;

/**
 * 文章详 服务层
 *
 * @author xingyu
 * @date 2019-01-10
 */
public interface ICmsArticleDataService {
    /**
     * 查询文章详信息
     *
     * @param id 文章详ID
     * @return 文章详信息
     */
    CmsArticleData selectCmsArticleDataById(String id);

    /**
     * 查询文章详列表
     *
     * @param cmsArticleData 文章详信息
     * @return 文章详集合
     */
    List<CmsArticleData> selectCmsArticleDataList(CmsArticleData cmsArticleData);

    /**
     * 新增文章详
     *
     * @param cmsArticleData 文章详信息
     * @return 结果
     */
    int insertCmsArticleData(CmsArticleData cmsArticleData);

    /**
     * 修改文章详
     *
     * @param cmsArticleData 文章详信息
     * @return 结果
     */
    int updateCmsArticleData(CmsArticleData cmsArticleData, CmsArticle cmsArticle);

    /**
     * 删除文章详信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteCmsArticleDataByIds(String ids);

}
