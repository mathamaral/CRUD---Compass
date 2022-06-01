package br.com.projeto.produto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projeto.produto.model.Products;
import br.com.projeto.produto.model.ProductsDTO;

public interface ProductsService {
	
	Products create(Products product);
	Optional findById(@PathVariable Integer id);
	List<Products> list();
	String delete(int id);
	Products update(int id, Products products);
	List<ProductsDTO> search(@RequestParam(required = false) Double max_price,
		@RequestParam(required = false) Double min_price, @RequestParam(required = false) String q);

}
