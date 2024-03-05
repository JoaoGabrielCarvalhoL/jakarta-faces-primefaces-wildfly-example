package br.com.joaogabriel.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.joaogabriel.entity.Product;
import br.com.joaogabriel.repository.ProductRepository;
import br.com.joaogabriel.service.ProductService;

public class ProductServiceImpl implements ProductService{
	
	private final Logger logger = Logger.getLogger(getClass().getName());
	private final ProductRepository productRepository = new ProductRepository(Product.class);
	
	@Override
	public Product save(Product product) {
		logger.log(Level.INFO, "Saving product into database.");
		return this.productRepository.save(product);
	}
	
	@Override
	public Product update(Product product) {
		logger.log(Level.INFO, "Updating product into database.");
		return this.productRepository.update(product);
	}
	@Override
	public Product findById(UUID id) {
		logger.log(Level.INFO, "Getting product by Id: " + id);
		return this.productRepository.findById(id);
	}
	@Override
	public void delete(UUID id) {
		logger.log(Level.WARNING, "Deleting product from database. Id: " + id);
		this.productRepository.delete(id);
	}
	@Override
	public List<Product> findAll() {
		logger.log(Level.INFO, "Getting all products!");
		return this.productRepository.findAll();
	}

	
}
