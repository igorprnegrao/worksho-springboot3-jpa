package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	//metodo para inserir
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
	        if(!userRepository.existsById(id)) throw new ResourceNotFoundException(id);
	        userRepository.deleteById(id);
	    }catch (DataIntegrityViolationException e){
	        throw new DatabaseException(e.getMessage());
	    }
		
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateData(entity, obj);
			return userRepository.save(entity);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setemail(obj.getemail());
		entity.setPhone(obj.getPhone());
	}
}
