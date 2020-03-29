package com.sc2.hackathome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class HackAtHomeBeApplication {

	@Autowired
	private ApplicationContext webApplicationContext;

	public static void main(String[] args) {
		SpringApplication.run(HackAtHomeBeApplication.class, args);
	}

}
