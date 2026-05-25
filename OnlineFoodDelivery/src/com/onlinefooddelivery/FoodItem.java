package com.onlinefooddelivery;

public class FoodItem {
	private String foodName;
	private String foodCategory;
	private String mainIngredient;
	private float foodPrice;
	
	/**
	 * @param foodName
	 * @param foodCategory
	 * @param foodPrice
	 */
	public FoodItem(String foodName, String foodCategory,String mainIngredient, float foodPrice) {
		super();
		this.foodName = foodName;
		this.foodCategory = foodCategory;
		this.mainIngredient = mainIngredient;
		this.foodPrice = foodPrice;
	}
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public float getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(float foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getMainIngredient() {
		return mainIngredient;
	}

	public void setMainIngredient(String mainIngredient) {
		this.mainIngredient = mainIngredient;
	}

	@Override
	public String toString() {
		return foodName + " | " + foodPrice + " | (" + foodCategory +" made of : " + mainIngredient +")";
	}
	
}
