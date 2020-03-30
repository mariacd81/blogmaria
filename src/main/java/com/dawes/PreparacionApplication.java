package com.dawes;

import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PreparacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreparacionApplication.class, args);
		Persistence.generateSchema("seguridad", null);
	}

}
