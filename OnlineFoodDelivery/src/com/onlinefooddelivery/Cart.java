package com.onlinefooddelivery;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<FoodItem, Integer> cart;
	private double totalBill=0;
	private double gst =0;
	private double deliveryCharge=0;
	
	
	public Cart() {
		super();
		this.cart = new HashMap<>();
	}
	

	public double getDeliveryCharge() {
		return deliveryCharge;
	}


	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}


	public void addItemToCart(FoodItem item, int qty) {
		this.cart.put(item, qty);
	}
	
	public void checkout() {
		for(Map.Entry<FoodItem, Integer> item : cart.entrySet()) {
			this.totalBill = this.totalBill + (item.getKey().getFoodPrice() * item.getValue());
		}
		this.gst = this.totalBill * 0.18;
		this.gst = Math.round(this.gst *100.00) /100.00;
		billSummary();
		this.totalBill =this.totalBill + this.gst + this.deliveryCharge;	
		System.out.println("--------------------------------------");
		System.out.println("Total Bill to pay: " + this.totalBill);
		System.out.println("--------------------------------------");
	}
	
	private void billSummary() {
		System.out.println("--------------Bill Summary---------------");
		System.out.println("Item Total Price : " + this.totalBill);
		System.out.println("Delivery Charge  : " + this.deliveryCharge);
		System.out.println("GST              : " + this.gst);
	}


	public void displayCart() {
		System.out.println("    Items      |    Qty    |    Price    ");
		for(Map.Entry<FoodItem, Integer> item : cart.entrySet()) {
			System.out.println(item.getKey().getFoodName() +" \t|\t"+ item.getValue() + "\t|\t" 
		+ (item.getKey().getFoodPrice() * item.getValue()));
		}
	}
	
	

}
