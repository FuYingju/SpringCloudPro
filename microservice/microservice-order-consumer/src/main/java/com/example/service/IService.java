package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@FeignClient(value = "PROVIDER")/**通过value绑定微服务的名字来指定调用哪个服务*/
public interface IService {

    @GetMapping("/toProvider/hello")/**调用PROVIDER微服务的@GetMapping("/toProvider/hello")*/
    public Map<String,Object> helloFeign();

}
