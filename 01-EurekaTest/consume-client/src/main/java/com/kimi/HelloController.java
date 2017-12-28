package com.kimi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        ServiceInstance instance = client.getInstances("SERVICE-HELLO").get(0);
        logger.info("/hello, host:"+instance.getHost()+",service_id:"+instance.getServiceId());
        return "Hello world!";
    }
}