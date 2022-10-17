package com.cg.fitnesstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FitnesstrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnesstrackerApplication.class, args);
	}

}
