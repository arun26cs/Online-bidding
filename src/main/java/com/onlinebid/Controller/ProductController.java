package com.onlinebid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import com.onlinebid.Service.ProductService;
import com.onlinebid.Service.UserService;
import com.onlinebid.model.Product;
import com.onlinebid.model.User;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Product> getAllProduct() {
		return productService.getAllProducts();
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/{id}")
	public Product getProduct(@PathVariable("id") Integer id) {
		return productService.getByProduct(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void updateProduct(@RequestBody Product user) {
		productService.updateProduct(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {
		productService.deleteProduct(id);
	}
	
	
}
