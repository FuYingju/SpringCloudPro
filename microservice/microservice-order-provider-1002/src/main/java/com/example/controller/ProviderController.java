package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/toProvider")
public class ProviderController {

    @RequestMapping("/hello")
    public Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "provider-1002");
        return map;
    }

}
