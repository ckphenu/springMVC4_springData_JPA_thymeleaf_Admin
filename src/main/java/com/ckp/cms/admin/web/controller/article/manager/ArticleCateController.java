package com.ckp.cms.admin.web.controller.article.manager;

import com.ckp.cms.admin.web.Constans;
import com.ckp.cms.admin.web.model.ArticleCate;
import com.ckp.cms.admin.web.service.ArticleCateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Ecic Chen on 2016/1/21.
 */
@Controller
@RequestMapping("/article/category")
public class ArticleCateController {

    @Autowired
    ArticleCateServices services;

    @RequestMapping
    public String category(Model model){
        model.addAttribute("articleCates",services.listAllArticleCates());
        return "article-category";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String categoryAdd(Model model){
        model.addAttribute("articleCate",new ArticleCate());
        return "article-category-add";
    }

    @RequestMapping(value = "/edit/{articleCateId}",method = RequestMethod.GET)
    public String categoryEdit(Model model,@PathVariable int articleCateId){

        if(articleCateId != 0){
            model.addAttribute("articleCate",services.findArticleCateById(articleCateId));
        }else {
            model.addAttribute("articleCate",new ArticleCate());
        }

        return "article-category-add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String categoryAddSubmit(ArticleCate articleCate,Model model){
        if(null == articleCate){
            return "更新失败！";
        }


        if(articleCate.getId() != null){
            ArticleCate temp = services.findArticleCateById(articleCate.getId());
            if(null != temp){
                articleCate.setStatus(temp.getStatus());
                articleCate.setCreateTime(temp.getCreateTime());
            }
            articleCate.setUpdateTime(new Date());
            model.addAttribute("message","编辑成功");
        }else{
            articleCate.setStatus(Constans.STATUS_VALID);
            articleCate.setCreateTime(new Date());
            articleCate.setUpdateTime(new Date());
            model.addAttribute("message","插入成功");
        }

        services.AddArticleCate(articleCate);
        model.addAttribute("display",true);
        return "article-category-add::content";
    }


    @RequestMapping(value = "/delect/{cateId}",method = RequestMethod.POST)
    @ResponseBody
    public String  categoryDelect(@PathVariable int cateId){
        services.delectArticleCate(cateId);
        return "删除成功！";
    }

    @RequestMapping(value = "/delect",method = RequestMethod.POST)
    @ResponseBody
    public String  categoryDelectAll(@RequestParam("data[]") int[] ids){
        services.delectArticleCateAll(ids);
        return "删除成功！";
    }

    @RequestMapping("/search/{searchKey}")
    public String categorySearch(@PathVariable String searchKey,Model model){
        model.addAttribute("articleCates",services.searchArticleCateByNameOrDesc(searchKey));
        return "article-category::content";
    }


}
