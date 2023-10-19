package com.example.dermicyclebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class DermiCycleBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DermiCycleBackendApplication.class, args);
	}

}
