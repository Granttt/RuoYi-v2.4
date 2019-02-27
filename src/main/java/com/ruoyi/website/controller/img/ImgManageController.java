package com.ruoyi.website.controller.img;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.website.img.entity.ImgManage;
import com.ruoyi.website.img.service.IImgManageService;
import com.ruoyi.website.menu.service.IWebMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 图片管理 信息操作处理
 * 
 * @author xingyu
 * @date 2019-01-12
 */
@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/img/imgManage")
public class ImgManageController extends BaseController {
    private String prefix = "website/img/imgManage";
	
	@Autowired
	private IImgManageService imgManageService;
	@Autowired
	private IWebMenuService webMenuService;
	
	@RequiresPermissions("img:imgManage:view")
	@GetMapping()
	public String imgManage()
	{
	    return prefix + "/imgInfoTree";
	}
	
	/**
	 * 查询图片管理列表
	 */
	@RequiresPermissions("img:imgManage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ImgManage imgManage) {
		startPage();
        List<ImgManage> list = imgManageService.selectImgManageList(imgManage);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出图片管理列表
	 */
	@RequiresPermissions("img:imgManage:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ImgManage imgManage) {
    	List<ImgManage> list = imgManageService.selectImgManageList(imgManage);
        ExcelUtil<ImgManage> util = new ExcelUtil<ImgManage>(ImgManage.class);
        return util.exportExcel(list, "imgManage");
    }
	
	/**
	 * 新增图片管理
	 */
	@RequiresPermissions("img:imgManage:add")
	@GetMapping("/add/{menuId}")
	public String add(@PathVariable("menuId") Long menuId, ModelMap mmap) {
		mmap.put("webMenu",webMenuService.selectWebMenuById(menuId));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存图片管理
	 */
	@RequiresPermissions("img:imgManage:add")
	@Log(title = "图片管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ImgManage imgManage) {
		imgManage.setCreateBy(ShiroUtils.getLoginName());
		imgManage.setCreateTime(new Date());
		return toAjax(imgManageService.insertImgManage(imgManage));
	}

	/**
	 * 修改图片管理
	 */
	@GetMapping("/edit/{imgId}")
	public String edit(@PathVariable("imgId") Long imgId, ModelMap mmap) {
		ImgManage imgManage = imgManageService.selectImgManageById(imgId);
		mmap.put("imgManage", imgManage);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存图片管理
	 */
	@RequiresPermissions("img:imgManage:edit")
	@Log(title = "图片管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ImgManage imgManage) {
		imgManage.setUpdateBy(ShiroUtils.getLoginName());
		imgManage.setUpdateTime(new Date());
		return toAjax(imgManageService.updateImgManage(imgManage));
	}
	
	/**
	 * 删除图片管理
	 */
	@RequiresPermissions("img:imgManage:remove")
	@Log(title = "图片管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(imgManageService.deleteImgManageByIds(ids));
	}
	
}
