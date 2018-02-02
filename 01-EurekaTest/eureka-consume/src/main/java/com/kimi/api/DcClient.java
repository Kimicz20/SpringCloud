package com.kimi.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-service")
public interface DcClient {

    @GetMapping("/dc")
    String consumer();
}
