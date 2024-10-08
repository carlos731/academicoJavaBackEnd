package br.com.senac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.senac.service.IniciaDbService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired 
	private IniciaDbService dbService;
	
	@Bean
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}
}
