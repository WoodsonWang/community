package com.woodson.community.controller;

import com.woodson.community.dto.PageDTO;
import com.woodson.community.mapper.UserMapper;
import com.woodson.community.model.User;
import com.woodson.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private QuestionService questionService;
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action")String action,
                          Model model,
                          HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/";
        }
        if ("my_question".equals(action)){
            model.addAttribute("section","myQuestion");
            model.addAttribute("sectionName","我的提问");
            PageDTO questions= questionService.getQuestionsById(1, 5, user.getId());
            model.addAttribute("question",questions);
        }

        return "profile";
    }
}
