package com.ruoyi.website.controller.cms;

import com.ruoyi.common.utils.IdGen;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.website.cms.entity.CmsArticle;
import com.ruoyi.website.cms.entity.CmsArticleData;
import com.ruoyi.website.cms.service.ICmsArticleDataService;
import com.ruoyi.website.cms.service.ICmsArticleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章 信息操作处理
 *
 * @author xingyu
 * @date 2019-01-10
 */
@Controller
@RequestMapping("/cms/cmsArticle")
public class CmsArticleController extends BaseController {
    private String prefix = "website/cms/cmsArticle";

    @Autowired
    private ICmsArticleService cmsArticleService;

    @Autowired
    private ICmsArticleDataService cmsArticleDataService;

    @RequiresPermissions("cms:cmsArticle:view")
    @GetMapping()
    public String cmsArticle() {
        return prefix + "/cmsArticle";
    }

    /**
     * 查询文章列表
     */
    @RequiresPermissions("cms:cmsArticle:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CmsArticle cmsArticle) {
        startPage();
        List<CmsArticle> list = cmsArticleService.selectCmsArticleList(cmsArticle);
        return getDataTable(list);
    }


    /**
     * 导出文章列表
     */
    @RequiresPermissions("cms:cmsArticle:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsArticle cmsArticle) {
        List<CmsArticle> list = cmsArticleService.selectCmsArticleList(cmsArticle);
        ExcelUtil<CmsArticle> util = new ExcelUtil<CmsArticle>(CmsArticle.class);
        return util.exportExcel(list, "cmsArticle");
    }

    /**
     * 新增文章
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存文章
     */
    @RequiresPermissions("cms:cmsArticle:add")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CmsArticle cmsArticle) {
        cmsArticle.setId(IdGen.uuid());
        cmsArticle.setCreateBy(ShiroUtils.getLoginName());
        CmsArticleData cmsArticleData = new CmsArticleData();
        cmsArticleData.setId(cmsArticle.getId());
        if (null != cmsArticle.getContent()) {
            cmsArticleData.setContent(cmsArticle.getContent());
        }
        if (null != cmsArticle.getCopyfrom()) {
            cmsArticleData.setCopyfrom(cmsArticle.getCopyfrom());
        }
        cmsArticleDataService.insertCmsArticleData(cmsArticleData);

        return toAjax(cmsArticleService.insertCmsArticle(cmsArticle));
    }

    /**
     * 修改文章
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        CmsArticle cmsArticle = cmsArticleService.selectCmsArticleById(id);
        CmsArticleData cmsArticleData = cmsArticleDataService.selectCmsArticleDataById(id);
        cmsArticle.setContent(cmsArticleData.getContent());
        cmsArticle.setCopyfrom(cmsArticleData.getCopyfrom());
        mmap.put("cmsArticle", cmsArticle);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章
     */
    @RequiresPermissions("cms:cmsArticle:edit")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CmsArticle cmsArticle) {
        cmsArticle.setUpdateBy(ShiroUtils.getLoginName());
        CmsArticleData cmsArticleData = cmsArticleDataService.selectCmsArticleDataById(cmsArticle.getId());
        cmsArticleDataService.updateCmsArticleData(cmsArticleData,cmsArticle);
        return toAjax(cmsArticleService.updateCmsArticle(cmsArticle));
    }

    /**
     * 删除文章
     */
    @RequiresPermissions("cms:cmsArticle:remove")
    @Log(title = "文章", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        cmsArticleDataService.selectCmsArticleDataById(ids);
        return toAjax(cmsArticleService.deleteCmsArticleByIds(ids));
    }

}
