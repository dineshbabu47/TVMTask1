package com.java.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TvmTask1Application {

	public static void main(String[] args) {
		SpringApplication.run(TvmTask1Application.class, args);
	}

}
