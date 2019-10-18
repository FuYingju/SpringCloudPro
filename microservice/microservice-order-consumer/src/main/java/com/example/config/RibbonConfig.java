package com.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClient(name = "PROVIDER", configuration = RibbonRuleConfig.class)
//通过用@RibbonClient来为Ribbon客户端声明额外的配置
//name 用来指定需要均衡的服务，即服务提供者，configuration 用来指定所用的策略配置，这里使用我们自定义的一个配置 RibbonRuleConfig。
//添加Ribbon的配置类，注意该类必须配置在@SpringBootApplication主类以外的包下。不然的话所有的服务都会按照这个规则来实现。会被所有的RibbonClient共享。主要是主类的主上下文和Ribbon的子上下文起冲突了。父子上下文不能重叠。
public class RibbonConfig {

    @Bean
    @LoadBalanced /*添加负载均衡,默认会轮询调用提供者*/
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
