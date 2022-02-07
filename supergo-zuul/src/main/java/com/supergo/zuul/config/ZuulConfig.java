package com.supergo.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Auther:xueruiheng
 * @Date:2022/1/29
 * @Description:com.supergo.zuul.config
 * @version:1.0
 * 跨域过滤器
 */

@Configuration
public class ZuulConfig {

    @Bean
    public CorsFilter corsFilter(){
        //1、添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //放行哪些原始域
        config.addAllowedOrigin("*");
        //放行哪些原始域（头部信息）
        config.addAllowedHeader("*");
        //放行哪些原始域（请求方式）
        config.addAllowedMethod("*");

        //添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**",config);
        CorsFilter corsFilter = new CorsFilter(configSource);
        return corsFilter;
    }
}
