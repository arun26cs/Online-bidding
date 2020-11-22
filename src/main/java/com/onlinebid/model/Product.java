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
	private Timestamp expirytime;
	private String soldflag;
	private String nextbid;
	private String userid;
	private float bidprice;
	
	
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
	
	 
	public String getSoldflag() {
		return soldflag;
	}
	public void setSoldflag(String soldflag) {
		this.soldflag = soldflag;
	}
	public String getNextbid() {
		return nextbid;
	}
	public void setNextbid(String nextbid) {
		this.nextbid = nextbid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public float getBidprice() {
		return bidprice;
	}
	public void setBidprice(float bidprice) {
		this.bidprice = bidprice;
	}
	public Product(Integer productid, String name, Timestamp expirytime, String soldflag, String nextbid, String userid,
			float bidprice) {
		super();
		this.productid = productid;
		this.name = name;
		this.expirytime = expirytime;
		this.soldflag = soldflag;
		this.nextbid = nextbid;
		this.userid = userid;
		this.bidprice = bidprice;
	}
	
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", expirytime=" + expirytime + ", soldflag="
				+ soldflag + ", nextbid=" + nextbid + ", userid=" + userid + ", bidprice=" + bidprice + "]";
	}
	public Product() {
		 
	}
	
	
}
