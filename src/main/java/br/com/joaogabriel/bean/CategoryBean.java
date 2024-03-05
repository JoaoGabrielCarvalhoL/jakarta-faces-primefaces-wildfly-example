package br.com.joaogabriel.bean;

import java.io.Serializable;
import java.util.List;

import org.omnifaces.util.Messages;

import br.com.joaogabriel.entity.Category;
import br.com.joaogabriel.service.CategoryService;
import br.com.joaogabriel.service.impl.CategoryServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class CategoryBean implements Serializable {
	
	private static final long serialVersionUID = 0L;
	
	private Category category;
	private CategoryService categoryService;
	private List<Category> categories;
	
	@PostConstruct
	public void init() {
		this.category = new Category();
		this.categoryService = new CategoryServiceImpl();
		list();
	}
	
	public void save() {
		this.categoryService.save(this.category);
		Messages.addGlobalInfo("Category saved into database.");
		cleanObject();
		list();
	}
	
	public void list() {
		this.categories = categoryService.findAll();
	}

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void cleanObject() {
		this.category = new Category();
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
