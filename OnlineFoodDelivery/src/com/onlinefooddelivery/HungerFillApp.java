package com.onlinefooddelivery;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HungerFillApp {
	
	public static void main(String[] args) {
		//Creating foodItems objects
		FoodItem vegPizza = new FoodItem("Paneer Pizza", "Veg","Paneer", 330);
		FoodItem chickenPizza = new FoodItem("Chicken Pizza", "Non-Veg","Chicken", 450);
		FoodItem pasta = new FoodItem("Mushroom Pasta", "Veg","Mushroom", 250);
		FoodItem ravioli = new FoodItem("Ravioli", "Veg","Ravioli", 440);
		FoodItem dalFry = new FoodItem("Dal Fry", "Veg","Yellow Lentils", 160);
		FoodItem bhendiFry = new FoodItem("Bhendi Fry", "Veg","Okra", 200);
		FoodItem pbm = new FoodItem("Paneer Butter Masala", "Veg","Paneer", 250);
		FoodItem kajuCurry = new FoodItem("Kaju Curry", "Veg","Cashew", 350);
		FoodItem chapati = new FoodItem("Chapati", "Veg","Wheat", 15);
		FoodItem paratha = new FoodItem("Paratha", "Veg","Wheat", 25);
		FoodItem manchurian = new FoodItem("Manchurian fry", "Veg","Cabage", 170);
		FoodItem schezwanNoodles = new FoodItem("Schezwan Noodles", "Veg","Boiled noodles", 240);
		FoodItem manchowSoup = new FoodItem("Veg Manchow Soup", "Veg","Mix Vegetable", 350);
		FoodItem chickenSoup = new FoodItem("Chicken Soup", "Non-Veg","Chicken", 350);
//		FoodItem tomatoSoup = new FoodItem("Tomato Soup", "Veg","Tomato", 350);
		
//		Restaurants creation with the list of food items
		Restaurant shanghaiWok = new Restaurant(1,"Shangai Wok"
				,Arrays.asList(manchurian,schezwanNoodles,chickenSoup,manchowSoup)
				,true,true,"Balewadi Chowpati"
				,"Chinese");
		Restaurant saiTeerth = new Restaurant(2,"Sai Teerth Restuarant"
				, Arrays.asList(dalFry,bhendiFry,pbm,kajuCurry,chapati,paratha)
				, true, true, "Baner"
				, "Maharashtrian and Punjabi");
		Restaurant italianCorner = new Restaurant(3,"Italian Corner"
				, Arrays.asList(vegPizza,chickenPizza,pasta)
				, true, true, "Shivaji Nagar"
				, "Italian");
		Restaurant littleItaly = new Restaurant(4,"Little Italy"
				, Arrays.asList(vegPizza,chickenPizza,pasta,ravioli)
				, true, true, "Tilak Road"
				, "Italian");
		/*
		 * Initial startup of program requirements
		 */
		DeliveryMode deliveryMode; // for dynamic binding
		Cart cart = new Cart();
		int checkout =1;
		Scanner sc = new Scanner(System.in);
		/*
		 * creating list of restaurants
		 */
		List<Restaurant> listOfRestuarants = Arrays.asList(shanghaiWok,saiTeerth,italianCorner,littleItaly);
		System.out.println("-----WELCOME TO HUNGERFILL-----");
		System.out.println();
		System.out.println("**********Restaurants**********");
		List<Restaurant> restuarants = listOfRestuarants.stream().sorted(Comparator.comparing(Restaurant::getId)).filter(r->r.isDelivery()).collect(Collectors.toList());
		Restaurant selectedRestaurant = new Restaurant();
		/*
		 * DONE: implemented to fetch the list of dishes from the available restaurants
		 * show id at menu for user input, trim it. scanner for user input.
		 */
		System.out.println();
//		while(checkout != 0) {
		restuarants.forEach(res->System.out.println(res.getId()+"."+res.getRestaurantName()));
		System.out.println();
		
		System.out.print("Select the Restaurant number to see menu and details : ");
		int choosedRestaurant = sc.nextInt();
		sc.nextLine();
		System.out.println();
		selectedRestaurant = listOfRestuarants.stream()
				.filter(rest->rest.getId()==choosedRestaurant)
				.findFirst().get();
		System.out.println("--------------------------------------------------------");
		System.out.println(selectedRestaurant.getRestaurantName() +", " + selectedRestaurant.getAddress() +" (Cuisine:"+ selectedRestaurant.getFoodCategory()+")");
		selectedRestaurant.displayMenu();
		System.out.println();
//			int addToCart =1;
		while(checkout !=0) {
			try {
				System.out.print("Select the Food Item number to add to Cart: ");
				int selectedFoodItem = sc.nextInt();
				sc.nextLine();
				if(selectedFoodItem > selectedRestaurant.getFoodItems().size()) {
					System.out.println("Invalid selection! Try Again");
					continue;
				}
				System.out.print("Enter Quantity for selected food item ("+ selectedRestaurant.getFoodItems().get(selectedFoodItem-1).getFoodName()+"): ");
				int qty = sc.nextInt();
				sc.nextLine();
				cart.addItemToCart(selectedRestaurant.getFoodItems().get(selectedFoodItem-1), qty);
				System.out.print("ENTER 1 to add another Item, else 0 to checkout:");
				checkout = sc.nextInt();
				sc.nextLine();
			}catch (ArrayIndexOutOfBoundsException e) {
				checkout = 0;
				System.out.println("----Displaying cart ---- ");	
			}	
		}
		System.out.println("------------------------------------");
		cart.displayCart();
		System.out.println("------------------------------------");
//			System.out.print("Enter 1 to continue, 0 to checkout:");
//			exit = sc.nextInt();
//			sc.nextLine();
//		}
//		cart.checkout();
		/*TODO
		 * add delivery mode selection and bill details implementation
		 */
		System.out.println();
		System.out.println("--------Delivery Modes Available--------");
		System.out.println("1. Bike delivery (Takes around 30-45 mins) \n"
				+ "2. Drone delivery (Takes around 20-30 mins) \n"
				+ "3. Express Delivery (Takes around 15-10 mins)");
		System.out.println("-----------------------------------------");
		System.out.println("Select Mode Of Delivery number");
		int selectedModeOfDelivery = sc.nextInt();
		double deliveryCharge;
		/*
		 * TODO: to check how to implement distance calculation 
		 * using 5km as distance as of now
		 */
		int distance = 5;
		sc.nextLine();
		switch(selectedModeOfDelivery) {
		case 1:
			deliveryMode = new BikeDelivery();
			deliveryCharge = deliveryMode.deliveryCharge(distance);
			cart.setDeliveryCharge(deliveryCharge);
			break;
		case 2:
			deliveryMode = new DroneDelivery();
			deliveryCharge = deliveryMode.deliveryCharge(distance);
			cart.setDeliveryCharge(deliveryCharge);
			break;
		case 3:
			deliveryMode = new ExpressDelivery();
			deliveryCharge = deliveryMode.deliveryCharge(distance);
			cart.setDeliveryCharge(deliveryCharge);
			break;
		default:
			System.out.println("Defalut selection Bike Delivery Applied");
			deliveryMode = new BikeDelivery();
			deliveryCharge = deliveryMode.deliveryCharge(distance);
			cart.setDeliveryCharge(deliveryCharge);
			break;
		}
		cart.checkout();
		System.out.println("Thank You for Ordering at " + selectedRestaurant.getRestaurantName()+"!");
		sc.close();
	}
	

}
