package com.customerproduct.customerproduct;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@Column(name="product_id")
	private int pid;
	@Column(name="product_name")
	private String pname;
	@Column(name="product_price")
	private double price;
	
	@ManyToMany(mappedBy="product")
	private List<Customer> customer;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, String pname, double price, List<Customer> customer) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.customer = customer;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String string) {
		this.pname = string;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

}
