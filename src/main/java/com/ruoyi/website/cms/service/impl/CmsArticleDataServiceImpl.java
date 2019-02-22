package com.ruoyi.website.cms.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.website.cms.entity.CmsArticle;
import com.ruoyi.website.cms.entity.CmsArticleData;
import com.ruoyi.website.cms.mapper.CmsArticleDataMapper;
import com.ruoyi.website.cms.service.ICmsArticleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章详 服务层实现
 *
 * @author xingyu
 * @date 2019-01-10
 */
@Service
public class CmsArticleDataServiceImpl implements ICmsArticleDataService {
    @Autowired
    private CmsArticleDataMapper cmsArticleDataMapper;

    /**
     * 查询文章详信息
     *
     * @param id 文章详ID
     * @return 文章详信息
     */
    @Override
    public CmsArticleData selectCmsArticleDataById(String id) {
        return cmsArticleDataMapper.selectCmsArticleDataById(id);
    }

    /**
     * 查询文章详列表
     *
     * @param cmsArticleData 文章详信息
     * @return 文章详集合
     */
    @Override
    public List<CmsArticleData> selectCmsArticleDataList(CmsArticleData cmsArticleData) {
        return cmsArticleDataMapper.selectCmsArticleDataList(cmsArticleData);
    }

    /**
     * 新增文章详
     *
     * @param cmsArticleData 文章详信息
     * @return 结果
     */
    @Override
    public int insertCmsArticleData(CmsArticleData cmsArticleData) {
        return cmsArticleDataMapper.insertCmsArticleData(cmsArticleData);
    }

    /**
     * 修改文章详
     *
     * @param cmsArticleData 文章详信息
     * @return 结果
     */
    @Override
    public int updateCmsArticleData(CmsArticleData cmsArticleData , CmsArticle cmsArticle) {
        if (null != cmsArticleData) {
            if (null != cmsArticle.getContent()) {
                cmsArticleData.setContent(cmsArticle.getContent());
            }
            if (null != cmsArticle.getCopyfrom()) {
                cmsArticleData.setCopyfrom(cmsArticle.getCopyfrom());
            }
        }
        return cmsArticleDataMapper.updateCmsArticleData(cmsArticleData);
    }

    /**
     * 删除文章详对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsArticleDataByIds(String ids) {
        return cmsArticleDataMapper.deleteCmsArticleDataByIds(Convert.toStrArray(ids));
    }

}
