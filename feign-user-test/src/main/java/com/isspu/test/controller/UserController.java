package com.isspu.test.controller;

import com.isspu.test.entity.User;
import com.isspu.test.client.UserClient;
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
    UserClient userClient;

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<User> getAll() {
        return userClient.getAllUser();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(String name, Boolean isBoy) {
        return userClient.add(name, isBoy);
    }
}
