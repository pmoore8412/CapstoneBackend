package com.mooremaking.mooremakingbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.mooremaking")
public class MooreMakingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MooreMakingBackendApplication.class, args);
	}

}
