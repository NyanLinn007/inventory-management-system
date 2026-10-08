package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Product;
import com.example.demo.service.Productservice;

import org.springframework.ui.Model;

@Controller
public class ProductController {
	private final Productservice productservice;
	
	 public ProductController(Productservice productservice) {
	        this.productservice = productservice;
	    }
@GetMapping("/products")
public String products(Model model) {
	  model.addAttribute(
	            "products",
	            productservice.getAllProducts()
	        );
	
	return "products";
}
@PostMapping("/products")
public String addProduct(Product product) {
	productservice.saveProduct(product);
	return "redirect:/products";
}

@GetMapping("/products/delete/{id}")
public String deleteProducts(@PathVariable Long id) {
	productservice.deleteProduct(id);
	return "redirect:/products";

}
@GetMapping("/products/edit/{id}")
public String editProduct(@PathVariable Long id, Model model) {
    Product product = productservice.getProductById(id);
    model.addAttribute("product", product);
    return "edit-product";
}

@PostMapping("/products/update")
public String updateProduct(Product product) {
    productservice.saveProduct(product);
    return "redirect:/products";
}
}
