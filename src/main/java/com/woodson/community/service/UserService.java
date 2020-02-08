package com.woodson.community.service;

import com.woodson.community.mapper.UserMapper;
import com.woodson.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    public void createOrUpdate(User user) {
        User dbUser = userMapper.findUserByCountId(user.getAccountId());
        if (user == null){
            userMapper.insert(user);
        }else{
            //用户存在
            userMapper.update(user);
        }
    }
}
