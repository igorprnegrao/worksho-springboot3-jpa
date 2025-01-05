package com.educandoweb.course.resourses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;


@RestController //@RestController é melhor usado quando você quer retornar 
// dados (por exemplo, JSON ou XML)
@RequestMapping(value = "/users") // é usada para mapear URLs para métodos 
//específicos em controladores 
public class UserResourse {
	
	@GetMapping  // annotation = mapeia apenas requisições do tipo GET
	public ResponseEntity<User> findAll() {
		
		User u = new User(1L, "Maria", "maria@gmail.com", "(91)9999-9999", "123456");
		
		return ResponseEntity.ok().body(u);
	};
	
}
