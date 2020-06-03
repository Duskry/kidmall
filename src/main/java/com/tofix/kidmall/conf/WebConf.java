package com.tofix.kidmall.conf;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author duskry ren
 * @description 一些配置
 * @date 2020/6/1
 **/
@SpringBootConfiguration
public class WebConf {

    /**
     * SpringMVC配置
     *
     * @return
     */
    @Bean
    WebMvcConfigurer configuration() {
        /**
         * 跨域问题解决  全部通过
         */
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*");
            }
        };
    }

}
