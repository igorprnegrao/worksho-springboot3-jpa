package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	//metodo para recuperar tudo
	public List<User> findAll(){
		return userRepository.findAll();
		
	}
	//metodo para recupera pelo id 
	public User FindById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}
	//metodo para inserir
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity, obj);
		return userRepository.save(entity);
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setemail(obj.getemail());
		entity.setPhone(obj.getPhone());
	}
}
