package com.login.nodatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.login")
public class LoginFormNoDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginFormNoDatabaseApplication.class, args);
	}

}





