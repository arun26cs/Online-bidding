package com.onlinebid.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebid.Exception.DataNotFoundException;
import com.onlinebid.Repository.ProductRepository;
import com.onlinebid.Repository.UserRepository;
import com.onlinebid.model.Product;
import com.onlinebid.model.User;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}
	
	
	public Product getByProduct(Integer id) {
		return productRepository.findById(id).orElseThrow(()->new DataNotFoundException("Product is not found"));
		 
		
	}
	
	public Product addProduct(Product product) {
		 try{
			 System.out.println(System.currentTimeMillis());
			 product.setExpirytime(new Timestamp(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(5)));
			 productRepository.save(product);
			 return product;
		 }catch(Exception exp) {
			 System.out.println("in throws");
			 throw(exp);
		 }
	}
	
	public void updateProduct(Product product) {
		Product foundProduct = productRepository.findById(product.getProductid()).get();
		foundProduct= product;
		productRepository.save(foundProduct);
	}
	
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}
}
