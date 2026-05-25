package com.onlinefooddelivery;

public class BikeDelivery implements DeliveryMode {
	private static final double BASE_FARE = 30.00; // e.g., ₹30
    private static final double PER_KM_RATE = 10.00;

	@Override
	public double deliveryCharge(double distanceKm) {
		 return BASE_FARE + (distanceKm * PER_KM_RATE);
	}

}
