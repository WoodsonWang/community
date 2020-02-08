package com.woodson.community.controller;

import com.woodson.community.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {
    @Autowired
    private QuestionMapper questionMapper;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Integer id,
                           Model model){
//        QuestionDTO questionDTO = questionMapper.getQuestionById(id);
//        model.addAttribute("question_dto",questionDTO);
        return "";
    }
}
