package com.woodson.community.community.service;

import com.woodson.community.community.dto.QuestionDTO;
import com.woodson.community.community.mapper.QuestionMapper;
import com.woodson.community.community.mapper.UserMapper;
import com.woodson.community.community.model.Question;
import com.woodson.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用service起到一个组装的作用
 * 可以使用usermapper和questionmapper
 * 将两者组装在一起，因为要用到question和user两个对象
 */
@Service
public class QuestionService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private QuestionMapper questionMapper;

    public List<QuestionDTO> getQuestions() {
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> questions = questionMapper.getQuestions();
        for (Question question : questions) {
            User user = userMapper.findUserByID(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//            将question中的数据复制到questionDTO对象中
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);

        }
        return questionDTOList;

    }
}
