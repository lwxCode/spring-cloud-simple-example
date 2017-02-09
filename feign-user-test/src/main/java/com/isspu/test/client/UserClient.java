package com.isspu.test.client;

import com.isspu.test.entity.User;
import com.isspu.test.hystrix.ClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by linwx on 2017/2/9.
 */
@FeignClient(value = "service-test", fallback = ClientHystrix.class)
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/getAllUser")
    List<User> getAllUser();

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "name") String name, @RequestParam(value = "isBoy") Boolean isBoy);

}
