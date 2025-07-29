package com.demo.db_secure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication(
		scanBasePackages = {
				"com.demo.db_secure", "io.landotech.productservice", "io.landotech.userservice", "io.landotech.auditservice"
		}
)
@EnableJpaAuditing
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
