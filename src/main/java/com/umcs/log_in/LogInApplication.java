package com.umcs.log_in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootApplication
public class LogInApplication {

	public static void main(String[] args) {
		System.out.println(BCrypt.hashpw("123", BCrypt.gensalt()));
		SpringApplication.run(LogInApplication.class, args);
	}

}
