package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.CategoryP;
import com.educandoweb.course.repositories.CategoryPRepository;


@Service
public class CategoryPService {
	@Autowired
	private CategoryPRepository categoryPRepository;
	
	public List<CategoryP> findAll(){
		return categoryPRepository.findAll();
	};
	
	public CategoryP findById(Long id) {
		Optional<CategoryP> obj = categoryPRepository.findById(id);
		return obj.get();
	}
}
