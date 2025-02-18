package com.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product_service.entity.Product;
import com.product_service.repository.ProductRepository;

import jakarta.ws.rs.POST;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository ProductRepository;
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return ProductRepository.save(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts() {
		return ProductRepository.findAll();
	}
	
	@GetMapping("/{ProductId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long ProductId) {
		Product product=ProductRepository.findById(ProductId).orElseThrow(()-> new RuntimeException("Product with Product it not exist"));
		return ResponseEntity.ok(product);
	}
	
	
	
}
