package com.xpsd.feign1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //注册服务
@EnableFeignClients // 使用Fegin来调用服务 要在启动类上加上这个注解
public class Feign1Application {

    public static void main(String[] args) {
        SpringApplication.run(Feign1Application.class, args);
    }

}
