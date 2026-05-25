package com.onlinefooddelivery;

public class DroneDelivery implements DeliveryMode {
	private static final double BASE_FARE = 50.00;
    private static final double PER_KM_RATE = 15.00;
    private static final double SURCHARGE = 20.00; // Drone surcharge
    private static final double WEIGHT_CHARGE = 20.00;

	@Override
	public double deliveryCharge(double distanceKm) {
		return BASE_FARE + (distanceKm * PER_KM_RATE) + WEIGHT_CHARGE + SURCHARGE;
	}

}
