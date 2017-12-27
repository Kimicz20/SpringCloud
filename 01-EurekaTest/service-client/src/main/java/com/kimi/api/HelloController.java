package com.kimi.api;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by geek on 2017/12/26.
 */
@RestController
public class HelloController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EurekaInstanceConfig config;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        logger.info("/hello, instanceId:{}, host:{}",config.getInstanceId(),config.getHostName(false));
        return "Hello world!";
    }
}