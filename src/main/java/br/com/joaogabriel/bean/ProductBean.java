package br.com.joaogabriel.bean;

import java.io.Serializable;
import java.util.List;

import org.omnifaces.util.Messages;

import br.com.joaogabriel.entity.Category;
import br.com.joaogabriel.entity.Product;
import br.com.joaogabriel.service.CategoryService;
import br.com.joaogabriel.service.ProductService;
import br.com.joaogabriel.service.impl.CategoryServiceImpl;
import br.com.joaogabriel.service.impl.ProductServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ProductBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Category> categories;
	private Product product;
	private CategoryService categoryService;
	private ProductService productService;
	private List<Product> products;
	
	@PostConstruct
	public void init() {
		this.categoryService = new CategoryServiceImpl();
		this.productService = new ProductServiceImpl();
		this.categories = categoryService.findAll();
		this.product = new Product();
		list();
	}
	
	public void save() {
		this.productService.save(product);
		Messages.addGlobalInfo("Saving product into database!");
		cleanObject();
		list();
	}
	
	public void info(Product product) {
		this.product = product;
	}
	
	public void remove() {
		this.productService.delete(this.product.getId());
		cleanObject();
		this.products = productService.findAll();
		Messages.addGlobalInfo("Product deleted successfully");
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	private void cleanObject() {
		this.product = new Product();
	}
	
	private void list() {
		this.products = this.productService.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
