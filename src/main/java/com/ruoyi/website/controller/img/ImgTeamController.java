package com.ruoyi.website.controller.img;

import com.ruoyi.website.img.entity.ImgManage;
import com.ruoyi.website.img.service.IImgManageService;
import com.ruoyi.website.menu.service.IWebMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 团队风采
 *
 * @author xingyu
 * @date 2019/1/29
 */
@Controller
@RequestMapping("/img/team")
public class ImgTeamController {
    private String prefix = "website/img/team";
    /** 每页显示记录条数 **/
    private static final int PAGE_SIZE = 12;
    @Autowired
    private IImgManageService imgManageService;
    @Autowired
    private IWebMenuService webMenuService;

    @RequiresPermissions("img:imgManage:view")
    @GetMapping()
    public String imgTeam(@RequestParam Long menuId, @RequestParam Integer page_no, ModelMap mmap) {
        ImgManage imgManage = new ImgManage();
        imgManage.setMenuId(menuId);
        imgManage.setStatus("0");
        //banner
        imgManage.setImageSort("B");
        List<ImgManage> bannerTeamList = imgManageService.selectImgManageList(imgManage);
        mmap.put("bannerTeamList",bannerTeamList);
        //主内容
        if(menuId != null){
            menuId = 13L;
        }
        if(null == page_no && 0 == page_no){
            page_no = 1;
        }
        //总条数
        int count= imgManageService.selectImgCount(imgManage);
        //起始条数
        int begin =PAGE_SIZE *(page_no -1);
        //总页数
        int totalpages= count/PAGE_SIZE +1;
        imgManage.setImageSort("L");
        List<ImgManage> teamList = imgManageService.selectTeamList(menuId,"L","0",begin,PAGE_SIZE);
        mmap.put("teamList",teamList);
        mmap.put("totalpapes",totalpages);
        //底部列表
        //轮播列表
        imgManage.setImageSort("F");
        List<ImgManage> lunTeamList = imgManageService.selectImgManageList(imgManage);
        mmap.put("lunTeamList",lunTeamList);
        //拼图列表
        imgManage.setImageSort("P");
        List<ImgManage> pinTeamList = imgManageService.selectImgManageList(imgManage);
        mmap.put("pinTeamList",pinTeamList);
        return prefix + "/team";
    }
}

