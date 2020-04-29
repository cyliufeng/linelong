package com.linelong;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LineLongRegistry {
    public static void main(String[] args) {
        SpringApplication.run(LineLongRegistry.class,args);
    }
}
