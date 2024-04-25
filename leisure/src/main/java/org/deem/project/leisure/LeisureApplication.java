package org.deem.project.leisure;

import org.deem.project.leisure.model.Roles;
import org.deem.project.leisure.repository.RoleRepository;
import org.deem.project.leisure.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.deem.project.leisure", "org.deem.project.leisure.controller", "org.deem.project.leisure.model", "org.deem.project.leisure.repository", "org.deem.project.leisure.service"})
public class LeisureApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeisureApplication.class, args);
	}

	
	@Bean
	CommandLineRunner run(UsuarioService usuarioService, RoleRepository roleRepository) {
		
		return args -> {
			if(roleRepository.findAll().size() == 0) {
				usuarioService.saveRole(new Roles("ROLE_USER"));
				usuarioService.saveRole(new Roles("ROLE_ADMIN"));
				usuarioService.saveRole(new Roles("ROLE_VENDEDOR"));
			}
		};
	}
	
}
