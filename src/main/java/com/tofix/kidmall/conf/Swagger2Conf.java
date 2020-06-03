package com.tofix.kidmall.conf;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author duskry ren
 * @description Swagger2 配置  接口文档地址 http://localhost:8080/swagger-ui.html
 * @date 2020/6/2
 **/
@SpringBootConfiguration
@EnableSwagger2
public class Swagger2Conf {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("kidmall")
                .description("mall前台模块接口文档")
                .version("1.0")
                .build();
    }
}
