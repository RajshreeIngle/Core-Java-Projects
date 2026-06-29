package com.customerproduct.customerproduct;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@Column(name="customer_id")
	private int id;
	@Column(name="customer_name")
	private String name;
	@Column(name="customer_city")
	private String city;
	
	@ManyToMany
	@JoinTable(
			name="customer_product",
			joinColumns = {@JoinColumn(name="customer_id")},
			inverseJoinColumns = {@JoinColumn(name="product_id")}
			)
	private List<Product> product;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, String city, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
