package com.woodson.community.service;

import com.woodson.community.dto.PageDTO;
import com.woodson.community.dto.QuestionDTO;
import com.woodson.community.exception.CustomizeErrorCode;
import com.woodson.community.exception.CustomizeException;
import com.woodson.community.mapper.QuestionMapper;
import com.woodson.community.mapper.UserMapper;
import com.woodson.community.model.Question;
import com.woodson.community.model.User;
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

    public PageDTO getQuestions(Integer page, Integer size) {
        Integer index = size*(page-1);
        PageDTO pageDTO = new PageDTO();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> questions = questionMapper.getQuestions(index,size);
        if (questions == null || questions.size() ==0 ){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//            将question中的数据复制到questionDTO对象中
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);

        }
        pageDTO.setQuestionDTOS(questionDTOList);
        Integer totalCount = questionMapper.getPageCount();
        pageDTO.setCurrentPage(page);
        pageDTO.setPage(totalCount,size);
        return pageDTO;

    }

    public PageDTO getQuestionsById(Integer page, Integer size,Integer id){

        return new PageDTO();
    }


}
