package br.com.joaogabriel.repository;

import java.util.UUID;

import br.com.joaogabriel.dao.impl.SimpleGenericDao;
import br.com.joaogabriel.entity.Category;

public class CategoryRepository extends SimpleGenericDao<Category, UUID> {

	public CategoryRepository(Class<Category> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
}
