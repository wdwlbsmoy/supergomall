package com.supergo.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Auther:xueruiheng
 * @Date:2022/1/26
 * @Description:PACKAGE_NAME
 * @version:1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
//扫描mybatis逆向工程生成的接口
@MapperScan("com.supergo.mapper")
public class ManagerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerServiceApplication.class,args);
    }
}
