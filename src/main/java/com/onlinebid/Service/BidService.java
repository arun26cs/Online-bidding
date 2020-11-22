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
import com.onlinebid.Repository.BidRepository;
import com.onlinebid.Repository.ProductRepository;
import com.onlinebid.Repository.UserRepository;
import com.onlinebid.model.Bid;
import com.onlinebid.model.Product;
import com.onlinebid.model.User;

@Service
public class BidService {

	@Autowired
	private BidRepository bidRepository;
	
	public List<Bid> getAllBids(){
		List<Bid> bids = new ArrayList<>();
		bidRepository.findAll().forEach(bids::add);
		return bids;
	}
	
	
	public Bid getByBid(Integer id) {
		return bidRepository.findById(id).orElseThrow(()->new DataNotFoundException("Product is not found"));
		 
		
	}
	
	 
	//finds against a product if the user alsredy is bid
	//this is to keep track of the usert against a product
	public boolean findUserByProductInBid(Integer id,String userid) {
		List<Product> p = bidRepository.findByProductid(id);
		for(Product prod:p) {
			if(prod.getUserid().equalsIgnoreCase(userid)) {
				return true;
			}
		}
		return false;
		
	}
 
	public Bid saveBid(Bid bid) {
		
		return bidRepository.save(bid);
	}
	
	public void updateBid(Bid bid) {
		Bid foundBid = bidRepository.findById(bid.getBidid()).get();
		foundBid= bid;
		bidRepository.save(foundBid);
	}
	
	public void deleteProduct(Integer id) {
		bidRepository.deleteById(id);
	}
}
