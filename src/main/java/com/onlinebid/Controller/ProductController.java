package com.onlinebid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebid.Service.BidService;
import com.onlinebid.Service.ProductService;
import com.onlinebid.Service.UserService;
import com.onlinebid.model.Bid;
import com.onlinebid.model.Product;
import com.onlinebid.model.User;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private BidService bidService;
	 
	
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
		product.setNextbid("N");
		product.setSoldflag("N");
		return productService.addProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void updateProduct(@RequestBody Product product) {
		 
		productService.updateProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value = "/{id}")
	public Bid updateAProduct(@PathVariable("id") Integer id,
							   @RequestParam("bidval") float bidval,
							   @RequestParam("user") String userid) {
		Product prod = productService.getByProduct(id);
		System.out.println(prod);
		//update only when the price of the product is less
		if(bidval>prod.getBidprice()) {
			prod.setBidprice(bidval);
			prod.setUserid(userid);
			prod.setNextbid("N");
			System.out.println(prod);
			System.out.println("updating product table");
			productService.updateProduct(prod);
		}
		else {
			System.out.println("Errored out for product value is either equal or less");
			return null;
			 
		}
		Bid bid = new Bid();
		boolean productAndUserIsThere = bidService.findUserByProductInBid(id,userid);
		if(!productAndUserIsThere) {
			return bidService.saveBid(bid);
		}else {
			return null;
		}
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {
		productService.deleteProduct(id);
	}
	
	 
	
	
}
