package br.com.joaogabriel.service;

import java.util.List;
import java.util.UUID;

import br.com.joaogabriel.entity.Product;

public interface ProductService {

	Product save(Product product);

	Product update(Product product);

	Product findById(UUID id);

	void delete(UUID id);

	List<Product> findAll();
}
