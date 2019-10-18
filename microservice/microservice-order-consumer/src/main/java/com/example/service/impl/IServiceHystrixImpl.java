package com.example.service.impl;

import com.example.service.IServiceHystrix;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class IServiceHystrixImpl implements IServiceHystrix {
    @Override
    public Map<String, Object> helloFeignHystrix() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("feign", "Feign出错啦");
        return map;
    }
}
