package com.marcelocarvalho.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelocarvalho.cursomc.domain.Category;
import com.marcelocarvalho.cursomc.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category find(Integer id) {
		Optional<Category> obj = categoryRepository.findById(id); 	
		return obj.orElse(null) ;
	}
	
}
