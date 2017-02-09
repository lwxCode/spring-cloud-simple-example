package com.isspu.test.controller;

import com.isspu.test.dao.UserMapper;
import com.isspu.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by linwx on 2017/2/9.
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<User> getAll() {
        return userMapper.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(String name, Boolean isBoy) {
        return userMapper.insert(name, isBoy);
    }
}
