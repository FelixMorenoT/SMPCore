package com.smp.core.app;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SmpCoreApplication {

	public static void main(String[] args) {		
		SpringApplication.run(SmpCoreApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.smp.core.app"))
				.build();
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfo("SMP", "SMP CORE", "1.0", "", new Contact("Felix & Pablo & Kevin",null, null), "", "", Collections.emptyList());
    }
	
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
       return builder.build();
    }
  
}
