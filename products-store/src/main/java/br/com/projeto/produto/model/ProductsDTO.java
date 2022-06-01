package br.com.projeto.produto.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductsDTO extends Products {

	private int id;
	private String description;
	private String name;
	private double price;
	
	public ProductsDTO(Products products) {
		this.id = products.getId();
		this.description = products.getDescription();
		this.name = products.getName();
		this.price = products.getPrice();
	}
	
	public ProductsDTO(){
		
	}
	
	public static List<ProductsDTO> converter(Optional<Products> products) {
		return products.stream().map(ProductsDTO::new).collect(Collectors.toList());
	}
	
	public static List<ProductsDTO> converter(List<Products> products) {
        return products.stream().map(ProductsDTO::new).collect(Collectors.toList());
    }

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

}
