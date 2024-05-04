package com.eluc.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                .groupName("Eluc")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com"))
                .paths(PathSelectors.any())
                .build();
    }


    @SuppressWarnings("all")
    public ApiInfo apiInfo(){
        return new ApiInfo(
                "test api",
                "test project",
                "v1.0",
                "8888@qq.com", //开发者团队的邮箱
                "Eluc",
                "Apache 2.0",  //许可证
                "http://www.apache.org/licenses/LICENSE-2.0" //许可证链接
        );
    }
}
