package com.woodson.community.controller;

import com.woodson.community.dto.QuestionDTO;
import com.woodson.community.mapper.QuestionMapper;
import com.woodson.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("question/{id}")
    public String question(@PathVariable(name = "id")Integer id,
                           Model model){
        System.out.println(id);
        QuestionDTO questionDTO = questionService.getQuestionById(id);
        model.addAttribute("question_dto",questionDTO);
        return "question";
    }
}
