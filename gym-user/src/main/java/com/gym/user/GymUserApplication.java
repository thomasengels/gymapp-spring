package com.gym.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@ComponentScan
@EnableJpaAuditing
@SpringBootApplication
public class GymUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymUserApplication.class, args);
	}
}
