package com.ruoyi.website.controller.profile;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.website.profile.entity.ProfileInfo;
import com.ruoyi.website.profile.service.IProfileInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公司简介 信息操作处理
 * 
 * @author xingyu
 * @date 2019-01-28
 */
@Controller
@RequestMapping("/profile/profileInfo")
public class ProfileInfoController extends BaseController {
    private String prefix = "website/profile/profileInfo";
	
	@Autowired
	private IProfileInfoService profileInfoService;
	
	@RequiresPermissions("profile:profileInfo:view")
	@GetMapping()
	public String profileInfo()
	{
	    return prefix + "/profileInfo";
	}
	
	/**
	 * 查询公司简介列表
	 */
	@RequiresPermissions("profile:profileInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProfileInfo profileInfo) {
		startPage();
        List<ProfileInfo> list = profileInfoService.selectProfileInfoList(profileInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出公司简介列表
	 */
	@RequiresPermissions("profile:profileInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProfileInfo profileInfo) {
    	List<ProfileInfo> list = profileInfoService.selectProfileInfoList(profileInfo);
        ExcelUtil<ProfileInfo> util = new ExcelUtil<ProfileInfo>(ProfileInfo.class);
        return util.exportExcel(list, "profileInfo");
    }
	
	/**
	 * 新增公司简介
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存公司简介
	 */
	@RequiresPermissions("profile:profileInfo:add")
	@Log(title = "公司简介", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ProfileInfo profileInfo) {
		return toAjax(profileInfoService.insertProfileInfo(profileInfo));
	}

	/**
	 * 修改公司简介
	 */
	@GetMapping("/edit/{proId}")
	public String edit(@PathVariable("proId") Integer proId, ModelMap mmap) {
		ProfileInfo profileInfo = profileInfoService.selectProfileInfoById(proId);
		mmap.put("profileInfo", profileInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存公司简介
	 */
	@RequiresPermissions("profile:profileInfo:edit")
	@Log(title = "公司简介", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProfileInfo profileInfo) {
		return toAjax(profileInfoService.updateProfileInfo(profileInfo));
	}
	
	/**
	 * 删除公司简介
	 */
	@RequiresPermissions("profile:profileInfo:remove")
	@Log(title = "公司简介", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(profileInfoService.deleteProfileInfoByIds(ids));
	}
	
}
