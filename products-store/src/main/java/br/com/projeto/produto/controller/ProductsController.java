package br.com.projeto.produto.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.produto.controller.form.ProductsForm;
import br.com.projeto.produto.model.Products;
import br.com.projeto.produto.model.ProductsDTO;
import br.com.projeto.produto.service.ProductsService;
import io.swagger.annotations.Api;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/products")
@Api(value = "Controller")
public class ProductsController {
	
	@Autowired
	ProductsService productsService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Products> create(@RequestBody ProductsForm form) {
		var product = new Products();
		BeanUtils.copyProperties(form, product); // converting a Form to Entity
		return ResponseEntity.status(HttpStatus.CREATED).body(productsService.create(product));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductsDTO> findById(@PathVariable Integer id) {
		Optional<Products> products = productsService.findById(id);
	
		return ResponseEntity.ok(new ProductsDTO(products.get()));
	}
	
	@GetMapping
	public ResponseEntity<List<Products>> list(){
	 	return ResponseEntity.ok(productsService.list());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductsDTO> update(@PathVariable("id") int id, @RequestBody Products products){
		Products product = productsService.update(id, products);
		return ResponseEntity.ok(new ProductsDTO(product));	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductsDTO> delete(@PathVariable ("id") int id) {
		productsService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/search")
	public List<ProductsDTO> search(@RequestParam(required = false) Double max_price,
		@RequestParam(required = false) Double min_price, @RequestParam(required = false) String q) {
		return productsService.search(max_price, min_price, q);
	}
}
