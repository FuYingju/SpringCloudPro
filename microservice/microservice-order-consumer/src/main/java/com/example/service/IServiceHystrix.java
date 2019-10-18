package com.example.service;

import com.example.service.impl.IServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@FeignClient(value="PROVIDER",fallback = IServiceHystrixImpl.class)
public interface IServiceHystrix {

    @GetMapping("/hello")/**调用PROVIDER微服务的@GetMapping("/hello")*/
    public Map<String,Object> helloFeignHystrix();

}
