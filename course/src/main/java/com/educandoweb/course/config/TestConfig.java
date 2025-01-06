package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
// classe para povoar BD (data base seeding)

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration // declarar a classe como configuração
@Profile("test") // espcificar que vai ser para teste
public class TestConfig implements CommandLineRunner {
	@Autowired // associar as classes para ativar a injeção de dependencia 
	private UserRepository userRepository; //injeção de dependencia User - testconfig
	//implementar o commandLineRunner para executar o cód quando a app inciar
	//método para executar o cód
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com","988988888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com","977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"), u1);
		
		//salvar a lista no repositório respectivo
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	
}
