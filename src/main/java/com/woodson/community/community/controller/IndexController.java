package com.woodson.community.community.controller;

import com.woodson.community.community.mapper.UserMapper;
import com.woodson.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 设置Controller可以接受前端的一个请求
 */
@Controller
public class IndexController {
    @Autowired(required = false)
    private UserMapper userMapper;

    @GetMapping("/")
    public String Hello(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
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

        //自动去寻找index模板
        return "index";

    }
}
