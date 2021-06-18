package fr.formation.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//!\ MUST NOT REMAIN /!\
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)

public class AuthenticationApplication {

    public static void main(String[] args) {
	SpringApplication.run(AuthenticationApplication.class, args);
    }

}
