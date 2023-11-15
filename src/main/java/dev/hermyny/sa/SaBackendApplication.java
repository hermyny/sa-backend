package dev.hermyny.sa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaBackendApplication.class, args);
	}

}
