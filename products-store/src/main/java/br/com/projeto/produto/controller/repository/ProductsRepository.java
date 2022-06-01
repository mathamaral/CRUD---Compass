package br.com.projeto.produto.controller.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.projeto.produto.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Number>{
	
	@Query(value = "SELECT * FROM Product WHERE (:q IS NULL OR (UPPER(name) LIKE UPPER(CONCAT('%', :q, '%'))"
			+ "OR UPPER(description) LIKE UPPER(CONCAT('%', :q, '%'))))"
			+ "AND (:min_price IS NULL OR price >= :min_price)"
			+ "AND (:max_price IS NULL OR price <= :max_price)", nativeQuery = true)
	List<Products> findMaxMinPrice(@Param("max_price") Double max_price, @Param("min_price") Double min_price,
			@Param("q") String q);
	
}
