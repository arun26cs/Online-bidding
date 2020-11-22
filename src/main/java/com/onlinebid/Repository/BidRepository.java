package com.onlinebid.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
import org.springframework.stereotype.Repository;

import com.onlinebid.model.Bid;
import com.onlinebid.model.Product;
import com.onlinebid.model.User;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

	 
	
	////says if the user is present
	public List<Product> findByProductid(Integer id);
}
