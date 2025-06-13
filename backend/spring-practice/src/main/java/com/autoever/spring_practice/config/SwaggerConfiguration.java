package com.autoever.spring_practice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@Configuration // 해당 클래스가 Spring 설정 클래스임을 나타낸다. Bean 등록이 가능함.
@EnableSwagger2 // Swagger 2 사용을 활성화함.
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        log.info("[Message] Request Swagger Configuration");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) // 아래의 apiInfo() 메서드를 통해 API의 정보 설정
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.autoever.spring_practice"))
                .paths(PathSelectors.any()) // 모든 경로 포함
                .build();
    }

    private ApiInfo apiInfo() { // Swagger Api 페이지에 표시할 정보 입력
        log.info("[Message] Request Swagger Configuration apiInfo()");
        return new ApiInfoBuilder()
                .title("Spring Boot Open API Test with Swagger")
                .description("Hyundai Autoever Coding School Practice")
                .version("1.0.0")
                .build();
    }
}