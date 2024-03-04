package br.com.joaogabriel.service;

import java.util.List;
import java.util.UUID;

import br.com.joaogabriel.entity.Category;

public interface CategoryService {
	
	Category save(Category category);
	
	Category update(Category category);
	
	Category findById(UUID id);
	
	void delete(UUID id);
	
	List<Category> findAll();

}
