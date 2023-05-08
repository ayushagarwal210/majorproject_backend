package com.speproject.majorproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MajorprojectApplication {
	static Logger logger= LogManager.getLogger(MajorprojectApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MajorprojectApplication.class, args);
		logger.info("Info log");
		logger.warn("Warn log");
		logger.error("Error log");
		logger.fatal("Fatal log");
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
}
