package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
// classe para povoar BD (data base seeding)

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration // declarar a classe como configuração
@Profile("test") // espcificar que vai ser para teste
public class TestConfig implements CommandLineRunner {
	@Autowired // associar as classes para ativar a injeção de dependencia 
	private UserRepository userRepository; //injeção de dependencia User - testconfig
	//implementar o commandLineRunner para executar o cód quando a app inciar
	//método para executar o cód
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com","988988888", "123456");
		
		User u2 = new User(null, "Alex Green", "alex@gmail.com","977777777", "123456");
		
		// 
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
	
	
}
