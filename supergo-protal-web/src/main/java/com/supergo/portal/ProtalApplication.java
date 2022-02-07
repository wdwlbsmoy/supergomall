package com.supergo.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/4
 * @Description:com.supergo.portal
 * @version:1.0
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.supergo.manager.feign")
public class ProtalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProtalApplication.class,args);
    }
}
