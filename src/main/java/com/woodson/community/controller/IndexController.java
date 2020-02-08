package com.woodson.community.controller;

import com.woodson.community.dto.PageDTO;
import com.woodson.community.mapper.UserMapper;
import com.woodson.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 设置Controller可以接受前端的一个请求
 */
@Controller
public class IndexController {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private QuestionService questionService;
    @GetMapping("/")
    public String Hello(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "5")Integer size){
        PageDTO questions = questionService.getQuestions(page,size);
        model.addAttribute("questions",questions);
        //自动去寻找index模板
        return "index";

    }
}
