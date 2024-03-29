package com.supergo.mapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Auther:xueruiheng
 * @Date:2022/1/23
 * @Description:com.supergo.mapper
 * @version:1.0
 */

@SpringBootApplication
@MapperScan("com.supergo.mapper")
public class MapperApplication {
    public static void main(String[] args) {
        SpringApplication.run(MapperApplication.class,args);
    }
}
