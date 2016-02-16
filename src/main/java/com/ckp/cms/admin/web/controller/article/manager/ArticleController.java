package com.ckp.cms.admin.web.controller.article.manager;

import com.ckp.cms.admin.web.Constans;
import com.ckp.cms.admin.web.model.Article;
import com.ckp.cms.admin.web.model.ArticleCate;
import com.ckp.cms.admin.web.service.ArticleCateServices;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ecic Chen on 2016/1/21.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleCateServices services;

    @RequestMapping
    public String index(Model model){
        List<ArticleCate> articleCates = services.listAllArticleCates();
        model.addAttribute("articleCates",articleCates);
        return "article-list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addArticle(Model model){
        model.addAttribute("article",new Article());
        return "article-add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addArticleSubmit(Model model,Article article){

        model.addAttribute("article",new Article());
        return "article-add";
    }
}
