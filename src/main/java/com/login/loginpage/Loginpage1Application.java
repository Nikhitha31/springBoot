package com.login.loginpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
@Import(SwaggerConfig.class)
@SpringBootApplication
public class Loginpage1Application {
  public static void main(String[] args) {
	  SpringApplication.run(Loginpage1Application.class, args);
	}
}
