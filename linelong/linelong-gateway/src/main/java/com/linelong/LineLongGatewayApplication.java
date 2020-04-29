package com.linelong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableDiscoveryClient //注册到注册中心
@EnableZuulProxy //开启zuul代理网关
public class LineLongGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(LineLongGatewayApplication.class,args);
    }
}
