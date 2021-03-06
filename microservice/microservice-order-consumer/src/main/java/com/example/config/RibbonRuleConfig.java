package com.example.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 自定义负载均衡策略
@Configuration
public class RibbonRuleConfig {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
