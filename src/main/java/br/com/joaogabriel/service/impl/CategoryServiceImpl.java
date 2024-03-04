package br.com.joaogabriel.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.joaogabriel.entity.Category;
import br.com.joaogabriel.repository.CategoryRepository;
import br.com.joaogabriel.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	private final Logger logger = Logger.getLogger(CategoryServiceImpl.class.getName());
	private final CategoryRepository categoryRepository = new CategoryRepository(Category.class);
	
	@Override
	public Category save(Category category) {
		logger.log(Level.INFO, "Saving category into database.");
		return this.categoryRepository.save(category);
		
	}
	@Override
	public Category update(Category category) {
		logger.log(Level.INFO, "Updating category into database.");
		return this.categoryRepository.update(category);
	}
	@Override
	public void delete(UUID id) {
		logger.log(Level.WARNING, "Deleting category by id: " + id);
		this.categoryRepository.delete(id);
	}
	@Override
	public List<Category> findAll() {
		logger.log(Level.INFO, "Getting all categories");
		return this.categoryRepository.findAll();
	}
	@Override
	public Category findById(UUID id) {
		logger.info("Getting category by id: " + id);
		return this.categoryRepository.findById(id);
	}

}
