package com.hotel.kanyadan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@ComponentScan("com.hotel.kanyadan.Controller")
public class SwaggerConfiguration {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        ParameterBuilder paramBuilder = new ParameterBuilder();
        paramBuilder
                .name("Authorization")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        List<Parameter> params =
                new ArrayList<>();
        params.add(paramBuilder.build());
        paramBuilder
                .name("ContextEntityId")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        params.add(paramBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("All Services")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hotel.kanyadan"))
                .build()
                .globalOperationParameters(params);
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Digi Comp API")
                .description("Digi Comp API for Services")
                .license("Apache License Version 2.0")
                .licenseUrl("")
                .version("2.0")
                .build();
    }
}
