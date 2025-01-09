package com.educandoweb.course.resourses;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController // @RestController é melhor usado quando você quer retornar
// dados (por exemplo, JSON ou XML) ENDPOINT
@RequestMapping(value = "/users") // é usada para mapear URLs para métodos
//específicos em controladores 
public class UserResourse {
	@Autowired
	private UserService userService;

	// recuperar info (Todos) do banco de dados
	@GetMapping // annotation = mapeia apenas requisições do tipo GET
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();

		return ResponseEntity.ok().body(list);
	};

	// recuperar info do banco de dados pelo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = userService.FindById(id);
		return ResponseEntity.ok().body(obj);
	}

	// inserir daddos
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}	
	
}
