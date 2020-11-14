package com.onlinebid.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="prod_seq")
	@SequenceGenerator(name = "prod_seq", sequenceName = "prod_seq", initialValue = 1, allocationSize=1)
	private Integer productid;
	private String name;
	private float price;
	private Timestamp expirytime;
	
	
	public Timestamp getExpirytime() {
		return expirytime;
	}
	public void setExpirytime(Timestamp expirytime) {
		this.expirytime = expirytime;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Product(int productid, String name, float price) {
		super();
		this.productid = productid;
		this.name = name;
		this.price = price;
	}
	public Product() {
		 
	}
	
	
}
