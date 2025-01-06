package com.educandoweb.course.resourses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.CategoryP;
import com.educandoweb.course.services.CategoryPService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryPResourse {

	@Autowired
	private CategoryPService categoryPService;
	
	@GetMapping
	public ResponseEntity<List<CategoryP>> findAll() {
		List<CategoryP> list = categoryPService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryP> findById(@PathVariable Long id) {
		CategoryP obj = categoryPService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
