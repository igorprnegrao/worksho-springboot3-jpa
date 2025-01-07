package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
// classe para povoar BD (data base seeding)

import com.educandoweb.course.entities.CategoryP;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryPRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
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
	@Autowired
	private CategoryPRepository categoryPRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		CategoryP cat1 = new CategoryP(null, "Electronics");
		CategoryP cat2 = new CategoryP(null, "Books");
		CategoryP cat3 = new CategoryP(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com","988988888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com","977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		
		
		//salvar a lista no repositório respectivo BD
		categoryPRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
	
	
}
