package com.ruoyi.website.controller.proj;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.website.menu.service.IWebMenuService;
import com.ruoyi.website.proj.entity.ProjInfo;
import com.ruoyi.website.proj.service.IProjInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ruoyi.common.utils.IdGen.uuid;

/**
 * 项目 信息操作处理
 * 
 * @author xingyu
 * @date 2019-01-15
 */
@Controller
@RequestMapping("/proj/projInfo")
public class ProjInfoController extends BaseController {
    private String prefix = "website/proj/projInfo";
	
	@Autowired
	private IProjInfoService projInfoService;
	@Autowired
	private IWebMenuService webMenuService;
	
	@RequiresPermissions("proj:projInfo:view")
	@GetMapping()
	public String projInfo()
	{
	    return prefix + "/projInfoTree";
	}
	
	/**
	 * 查询项目列表
	 */
	@RequiresPermissions("proj:projInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProjInfo projInfo) {
		startPage();
        List<ProjInfo> list = projInfoService.selectProjInfoList(projInfo);
		return getDataTable(list);
	}
	
	/**
	 * 导出项目列表
	 */
	@RequiresPermissions("proj:projInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjInfo projInfo) {
    	List<ProjInfo> list = projInfoService.selectProjInfoList(projInfo);
        ExcelUtil<ProjInfo> util = new ExcelUtil<ProjInfo>(ProjInfo.class);
        return util.exportExcel(list, "projInfo");
    }
	
	/**
	 * 新增项目
	 */
	@RequiresPermissions("proj:projInfo:add")
	@GetMapping("/add/{menuId}")
	public String add(@PathVariable("menuId") Long menuId, ModelMap mmap) {
		mmap.put("webMenu",webMenuService.selectWebMenuById(menuId));
		return prefix + "/add";
	}
	
	/**
	 * 新增保存项目
	 */
	@RequiresPermissions("proj:projInfo:add")
	@Log(title = "项目", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ProjInfo projInfo) {
		projInfo.setId(uuid());
		projInfo.setCreateBy(ShiroUtils.getLoginName());
		return toAjax(projInfoService.insertProjInfo(projInfo));
	}

	/**
	 * 修改项目
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap) {
		ProjInfo projInfo = projInfoService.selectProjInfoById(id);
		mmap.put("projInfo", projInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存项目
	 */
	@RequiresPermissions("proj:projInfo:edit")
	@Log(title = "项目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProjInfo projInfo) {
		projInfo.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(projInfoService.updateProjInfo(projInfo));
	}
	
	/**
	 * 删除项目
	 */
	@RequiresPermissions("proj:projInfo:remove")
	@Log(title = "项目", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(projInfoService.deleteProjInfoByIds(ids));
	}
	
}
