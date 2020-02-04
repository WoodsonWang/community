package com.woodson.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 设置Controller可以接受前端的一个请求
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String Hello(){
        //自动去寻找index模板
        return "index";

    }
}
