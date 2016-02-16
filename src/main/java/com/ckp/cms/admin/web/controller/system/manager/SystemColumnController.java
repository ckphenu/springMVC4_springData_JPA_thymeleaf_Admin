package com.ckp.cms.admin.web.controller.system.manager;

import com.ckp.cms.admin.web.Constans;
import com.ckp.cms.admin.web.model.ArticleCate;
import com.ckp.cms.admin.web.model.ContentType;
import com.ckp.cms.admin.web.model.SystemColumn;
import com.ckp.cms.admin.web.service.SystemColumnServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Ecic Chen on 2016/1/25.
 */
@Controller
@RequestMapping("/sys/manager/column")
public class SystemColumnController {


    @Autowired
    SystemColumnServices services;

    @RequestMapping
    public String index(Model model){
        List<SystemColumn> allColumns = services.listAllColumns();
        model.addAttribute("allColumns",allColumns);
        return "system-column";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        List<SystemColumn> allColumns = services.listAllColumns();
        model.addAttribute("allColumns",allColumns);

        List<ContentType> contentTypes = services.listAllContentType();
        model.addAttribute("contentTypes",contentTypes);

        model.addAttribute("systemColumn",new SystemColumn());
        return "system-column-add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String categoryAddSubmit(SystemColumn systemColumn,Model model){
        if(null == systemColumn){
            return "更新失败！";
        }


        if(systemColumn.getId() != null){
/*            ArticleCate temp = services.findArticleCateById(articleCate.getId());
            if(null != temp){
                systemColumn.setStatus(temp.getStatus());
                systemColumn.setCreateTime(temp.getCreateTime());
            }
            systemColumn.setUpdateTime(new Date());
            model.addAttribute("message","编辑成功");*/
        }else{
            systemColumn.setStatus(Constans.STATUS_VALID);
            systemColumn.setCreateTime(new Date());
            systemColumn.setUpdateTime(new Date());

            int level = services.getLevelByParentId(systemColumn.getParentId());
            systemColumn.setLevel(level);

            int index = services.getIndexByParentId(systemColumn.getParentId());
            systemColumn.setIndex(index);

            model.addAttribute("message","插入成功");
        }

        services.addSystemColumn(systemColumn);
        model.addAttribute("display",true);
        return "system-column-add::content";
    }

    @RequestMapping(value = "/delect/{systemColumnId}",method = RequestMethod.POST)
    @ResponseBody
    public String systemColumnDelect(@PathVariable int systemColumnId){
        services.delectSystemColumn(systemColumnId);
        return "删除成功！";
    }

    @RequestMapping(value = "/delect",method = RequestMethod.POST)
    @ResponseBody
    public String systemColumnAll(@RequestParam("data[]") int[] ids){
        services.delectSystemColumnAll(ids);
        return "删除成功！";
    }

    @RequestMapping(value = "/edit/{systemColumnId}",method = RequestMethod.GET)
    public String systemColumnEdit(Model model,@PathVariable int systemColumnId){

        if(systemColumnId != 0){
            model.addAttribute("articleCate",services.findSystemColumnById(systemColumnId));
        }else {
            model.addAttribute("articleCate",new ArticleCate());
        }

        return "system-column-add";
    }

    @RequestMapping("/search/{searchKey}")
    public String systemColumnSearch(@PathVariable String searchKey,Model model){
        model.addAttribute("allColumns",services.searchSystemColumnByTitleOrAlias(searchKey));
        return "system-column::content";
    }
}
