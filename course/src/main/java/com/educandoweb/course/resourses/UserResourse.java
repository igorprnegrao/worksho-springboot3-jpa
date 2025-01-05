package com.educandoweb.course.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;



@RestController //@RestController é melhor usado quando você quer retornar 
// dados (por exemplo, JSON ou XML)
@RequestMapping(value = "/users") // é usada para mapear URLs para métodos 
//específicos em controladores 
public class UserResourse {
	@Autowired
	private UserService userService;
	
	@GetMapping  // annotation = mapeia apenas requisições do tipo GET
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();
		
		
		return ResponseEntity.ok().body(list);
	};
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = userService.FindById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
