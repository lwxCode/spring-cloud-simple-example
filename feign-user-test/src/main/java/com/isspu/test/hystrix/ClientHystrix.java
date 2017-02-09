package com.isspu.test.hystrix;

import com.isspu.test.client.UserClient;
import com.isspu.test.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

/**
 * Created by linwx on 2017/2/9.
 */
@Component
public class ClientHystrix implements UserClient {

    @Override
    public Integer add(@RequestParam(value = "name") String name, @RequestParam(value = "isBoy") Boolean isBoy) {
        return -9999;
    }

    @Override
    public List<User> getAllUser() {
        return Collections.emptyList();
    }
}
