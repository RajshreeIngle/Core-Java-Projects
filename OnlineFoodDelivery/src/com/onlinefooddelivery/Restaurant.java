package com.onlinefooddelivery;

import java.util.List;

public class Restaurant {
	/*
	 * TODO id- restaurant number, 
	 */
	private int id;
	private String restaurantName;
	private List<FoodItem> foodItems;
	private boolean delivery; 
	private boolean takeaway;
	private String address;
	private String foodCategory;
	

	/**
	 * @param foodItems
	 * @param delivery
	 * @param takeaway
	 * @param address
	 * @param foodCategory
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 */
	public Restaurant() {
		super();
	}

	public Restaurant(int id,String restaurantName, List<FoodItem> foodItems, boolean delivery, boolean takeaway, String address,
			String foodCategory) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.foodItems = foodItems;
		this.delivery = delivery;
		this.takeaway = takeaway;
		this.address = address;
		this.foodCategory = foodCategory;
	}
	
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}
	
	public boolean isDelivery() {
		return delivery;
	}
	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}
	public boolean isTakeaway() {
		return takeaway;
	}
	public void setTakeaway(boolean takeaway) {
		this.takeaway = takeaway;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	/*
	 * Display Menu method here
	 */
	public void displayMenu() {
		System.out.println("----------------Restaurant Menu----------------");
		if(foodItems.isEmpty()) {
			System.out.println("No items available currently");
		}else {
			for(FoodItem item: foodItems) {
				System.out.print(foodItems.indexOf(item)+1 +" ");
				System.out.println(item);
			}
		}
	}
	
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", restaurantName=" + restaurantName + ", foodItems=" + foodItems
				+ ", delivery=" + delivery + ", takeaway=" + takeaway + ", address=" + address + ", foodCategory="
				+ foodCategory + "]";
	}
	
}
