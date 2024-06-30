package com.chatapp.talky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TalkyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalkyApplication.class, args);
	}

}
