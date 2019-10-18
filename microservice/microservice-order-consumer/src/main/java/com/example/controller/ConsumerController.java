package com.example.controller;

import com.example.service.IService;
import com.example.service.IServiceHystrix;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IService iService;
    @Autowired
    private IServiceHystrix iServiceHystrix;
    @Autowired
    private DiscoveryClient discoveryClient;  // 进行eureka的发现服务

    @GetMapping("/helloRibbon")
    public Map helloRibbon() {
        return restTemplate.getForObject("http://PROVIDER/toProvider/hello", Map.class);
    }

    @GetMapping("/helloFeign")
    public Map helloFeign() {
        return iService.helloFeign();
    }

    //断路器配置，当无法调用如下方法时，就会调用自定义的errorMethod方法
    @HystrixCommand(fallbackMethod = "errorMethod")
    @GetMapping("/helloRibbonHystrix")
    public Map helloRibbonHystrix(){
        // 故意写错访问路径
        return restTemplate.getForObject("http://PROVIDER/hello", Map.class);
    }

    public Map<String, Object> errorMethod() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ribon", "Ribon出错啦");
        return map;
    }

    @GetMapping("/helloFeignHystrix")
    public Map helloFeignHystrix() {
        return iServiceHystrix.helloFeignHystrix();
    }

    /**
     * 直接返回发现服务信息
     * eureka服务管理页面就是通过此类返回的信息显示
     */
    @GetMapping("/discover")
    public Object discover(){
        /*List<String> list = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICE-ORDER-CONSUMER");
        for (ServiceInstance element : instances){
            System.err.println(element.getServiceId());
            System.err.println(element.getHost());
            System.err.println(element.getPort());
            System.err.println(element.getUri());
        }*/
        Map<String,List<ServiceInstance>> instances = new HashMap<>();
        List<String> services = discoveryClient.getServices();
        for(String service:services){
            List<ServiceInstance> sis = discoveryClient.getInstances(service);
            instances.put(service,sis);
        }
        return instances;
    }

}
