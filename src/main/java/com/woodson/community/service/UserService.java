package com.woodson.community.service;

import com.woodson.community.mapper.UserMapper;
import com.woodson.community.model.User;
import com.woodson.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    public void createOrUpdate(User user) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(example);

        if (users.size() == 0){
            userMapper.insert(user);
        }else{
            //用户存在
//            此时不用修改用户创建的时间
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andIdEqualTo(user.getId());
            userMapper.updateByExampleSelective(updateUser,example);
        }
    }
}
