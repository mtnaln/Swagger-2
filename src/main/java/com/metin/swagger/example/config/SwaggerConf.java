package com.metin.swagger.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConf {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.metin.swagger.example"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Movie and Person API", // başlık
                "Movie and Person API", // açıklama
                "v1", // versiyon
                "xxx", // servis url
                new Contact("Metin Alnıaçık", "http://metinalniacik.com", "mtnaln@gmail.com"), // iletişim bilgileri
                "Apache License Version 2.0", // lisans
                "https://www.apache.org/licence.html" // lisans url
        );

        return apiInfo;
    }

}