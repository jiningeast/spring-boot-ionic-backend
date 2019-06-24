package com.marcelocarvalho.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelocarvalho.cursomc.domain.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Category> list() {
		
		Category cat1 = new Category(1, "Info");
		
		Category cat2 =  new Category(2, "Office");
		
		List<Category> listCat = new ArrayList<>();
		
		listCat.add(cat1);
		listCat.add(cat2);
		
		return listCat;
	}
	
	
}
