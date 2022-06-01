package br.com.projeto.produto.controller.form;

import br.com.projeto.produto.controller.repository.ProductsRepository;
import br.com.projeto.produto.model.Products;

public class ProductsForm {

	private String description;
	private String name;
	private double price;

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Products converter(ProductsRepository productsRepository) {
		return new Products(name, description, price);
	}
	

}
