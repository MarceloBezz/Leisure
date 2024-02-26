package org.deem.project.leisure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.deem.project.leisure", "org.deem.project.leisure.controller", "org.deem.project.leisure.model", "org.deem.project.leisure.repository", "org.deem.project.leisure.service"})
public class LeisureApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeisureApplication.class, args);
	}

}
