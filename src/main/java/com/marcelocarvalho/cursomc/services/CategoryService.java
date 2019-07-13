package com.marcelocarvalho.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelocarvalho.cursomc.domain.Category;
import com.marcelocarvalho.cursomc.repositories.CategoryRepository;
import com.marcelocarvalho.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category find(Integer id) {
		Optional<Category> obj = categoryRepository.findById(id); 	
		return obj.orElseThrow(()-> new ObjectNotFoundException ("Object not found! ID: "+ id +", TypeSink Sink :" + Category.class.getName()));
				
	}
	
	public Category insert (Category obj) {
		obj.setId(null);
		return categoryRepository.save(obj);
	}
	
}
