package com.educandoweb.course.resourses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;


@RestController //anotation = recurso web / controlado por um recurso rest
@RequestMapping(value = "/users") //  nome para o recurso /caminho para entidade users 
public class UserResourse {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "(91)9999-9999", "123456");
		
		return ResponseEntity.ok().body(u);
	};
	
}
