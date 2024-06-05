package com.heima.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger {
    @Bean
    public Docket docket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.apiInfo(new ApiInfoBuilder()
                .contact(new Contact("豪哥", "", "911929630@qq.com"))
                .version("1.0-snapshot")
                .title("豪哥头条-user")
                .description("豪哥头条是今日头条的前身").build());
        docket = docket.select().apis(RequestHandlerSelectors.basePackage("com.zhouhao.controller")).build();
        docket = docket.select().paths(PathSelectors.any()).build();
        return docket;
    }
}
