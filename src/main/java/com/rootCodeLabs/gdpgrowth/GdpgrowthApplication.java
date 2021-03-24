package com.rootCodeLabs.gdpgrowth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GdpgrowthApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdpgrowthApplication.class, args);
	}

}
