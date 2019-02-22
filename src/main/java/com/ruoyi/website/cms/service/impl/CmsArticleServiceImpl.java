package com.ruoyi.website.cms.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.website.cms.entity.CmsArticle;
import com.ruoyi.website.cms.mapper.CmsArticleDataMapper;
import com.ruoyi.website.cms.mapper.CmsArticleMapper;
import com.ruoyi.website.cms.service.ICmsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文章 服务层实现
 *
 * @author xingyu
 * @date 2019-01-10
 */
@Service
public class CmsArticleServiceImpl implements ICmsArticleService {
    @Autowired
    private CmsArticleMapper cmsArticleMapper;
    @Autowired
    private CmsArticleDataMapper cmsArticleDataMapper;

    /**
     * 查询文章信息
     *
     * @param id 文章ID
     * @return 文章信息
     */
    @Override
    public CmsArticle selectCmsArticleById(String id) {
        return cmsArticleMapper.selectCmsArticleById(id);
    }

    /**
     * 查询文章列表
     *
     * @param cmsArticle 文章信息
     * @return 文章集合
     */
    @Override
    public List<CmsArticle> selectCmsArticleList(CmsArticle cmsArticle) {
        return cmsArticleMapper.selectCmsArticleList(cmsArticle);
    }

    @Override
    public List<CmsArticle> selectCmsArticlePage(Integer begin, Integer size) {
        return cmsArticleMapper.selectCmsArticlePage(begin,size);
    }

    /**
     * 新增文章
     *
     * @param cmsArticle 文章信息
     * @return 结果
     */
    @Override
    public int insertCmsArticle(CmsArticle cmsArticle) {
        return cmsArticleMapper.insertCmsArticle(cmsArticle);
    }

    /**
     * 修改文章
     *
     * @param cmsArticle 文章信息
     * @return 结果
     */
    @Override
    public int updateCmsArticle(CmsArticle cmsArticle) {
        return cmsArticleMapper.updateCmsArticle(cmsArticle);
    }

    /**
     * 删除文章对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteCmsArticleByIds(String ids) {
        cmsArticleDataMapper.deleteCmsArticleDataByIds(Convert.toStrArray(ids));
        return cmsArticleMapper.deleteCmsArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 查询总条数
     */
    @Override
    public int selectCmsArticleCount(){
        return cmsArticleMapper.selectCmsArticleCount();
    }

}
