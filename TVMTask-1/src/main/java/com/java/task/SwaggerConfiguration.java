package com.java.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("college-api")
				.apiInfo(apiInfo()).select().build();
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("College Management API")
				.description("College management API reference for Clients")
				.termsOfServiceUrl("http://arunai.com")
				.contact("arunai@gmail.com").license("TVM License")
				.licenseUrl("tvm@gmail.com").version("1.0").build();
	}

}