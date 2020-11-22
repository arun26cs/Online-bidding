package com.onlinebid.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bid")
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bid_seq")
	@SequenceGenerator(name = "bid_seq", sequenceName = "bid_seq", initialValue = 1, allocationSize=1)
	private Integer bidid;
	private Integer productid; 
	private String userid;
	public Integer getBidid() {
		return bidid;
	}
	public void setBidid(Integer bidid) {
		this.bidid = bidid;
	}
	 
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Bid() {
		 
	} 
	
	
}
