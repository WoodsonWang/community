package com.woodson.community.community.controller;

import com.woodson.community.community.dto.QuestionDTO;
import com.woodson.community.community.mapper.QuestionMapper;
import com.woodson.community.community.mapper.UserMapper;
import com.woodson.community.community.model.Question;
import com.woodson.community.community.model.User;
import com.woodson.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
                        Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null &&cookies.length != 0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        List<QuestionDTO> questions = questionService.getQuestions();
        model.addAttribute("questions",questions);
        //自动去寻找index模板
        return "index";

    }
}
