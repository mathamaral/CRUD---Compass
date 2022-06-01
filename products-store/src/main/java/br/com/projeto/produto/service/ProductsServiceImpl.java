package br.com.projeto.produto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projeto.produto.controller.repository.ProductsRepository;
import br.com.projeto.produto.model.Products;
import br.com.projeto.produto.model.ProductsDTO;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	public ProductsServiceImpl(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}
	
	@Autowired
	ProductsRepository productsRepository;
	
	@Override
	public Products create(Products product) {
		return productsRepository.save(product);
	}

	@Override
	public Optional findById( @PathVariable Integer id){
		return productsRepository.findById(id);
		
	}

	@Override
	public List<Products> list() {
		return productsRepository.findAll();
	}
	
	@Override
	public Products update(int id, Products products)  {
		Optional<Products> productsById = productsRepository.findById(id);
		
		if(productsById.isPresent()) {
			Products updatedProducts = productsById.get();
		
			updatedProducts.setName(products.getName());
			updatedProducts.setDescription(products.getDescription());
			updatedProducts.setPrice(products.getPrice());
			products = productsRepository.save(updatedProducts);
			
			return updatedProducts;
		}
		return null;

	}

	@Override
	public String delete(int id) {
		productsRepository.deleteById(id);; //
		return "id" + id + "is deleted successfully"; 
	}
	
	@Override
	public List<ProductsDTO> search(@RequestParam(required = false) Double max_price,
		@RequestParam(required = false) Double min_price, @RequestParam(required = false) String q) {
		List<Products> product = productsRepository.findMaxMinPrice(max_price, min_price, q);
		return ProductsDTO.converter(product);
	}


}
