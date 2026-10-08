package com.example.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;


@Service
public class Productservice {
private final ProductRepository productRepository;

public Productservice(ProductRepository productRepository){
	this.productRepository=productRepository;
}

public List<Product> getAllProducts(){
	return productRepository.findAll();
}

public Product saveProduct(Product product) {
	return productRepository.save(product);
}

public void deleteProduct(Long id) {
	productRepository.deleteById(id);
}

public Product getProductById(Long id) {
    return productRepository.findById(id).orElse(null);
}
}
