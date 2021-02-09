package com.userRegidtrstion.swaggerDocumentation;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
    public Docket createDocket() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.userRegidtrstion.controller"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiEndPointInfo());                                           
    }
	    public ApiInfo apiEndPointInfo(){

			return new ApiInfo("Spring Boot Rest API User Registration And SignIn","","1.0", 
								"www.KunalDemo.com", new Contact(" Kunal Hirdekar",
								"kunal.blogger.in","kunalhirdekar22@gmail.com"),
								"License-A2B341234","www.krunal.license-index",
								Collections.emptyList());}
}
