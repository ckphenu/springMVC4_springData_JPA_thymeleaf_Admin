package com.ckp.cms.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ecic Chen on 2015/12/18.
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String admin(){
        return "index";
    }
}
