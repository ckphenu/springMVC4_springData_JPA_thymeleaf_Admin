package com.ckp.cms.admin.web.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

/**
 * Created by Ecic Chen on 2015/12/18.
 */
@Controller
public class AdminController {



    @RequestMapping("/")
    public String admin(){
        return "index";
    }
}
