package br.com.joaogabriel.bean;

import java.io.Serializable;

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
	
	@PostConstruct
	public void init() {
		this.category = new Category();
		this.categoryService = new CategoryServiceImpl();
	}
	
	public void save() {
		this.categoryService.save(this.category);
		Messages.addGlobalInfo("Category saved into database.");
		cleanObject();
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
}
