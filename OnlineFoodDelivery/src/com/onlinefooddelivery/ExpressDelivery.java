package com.onlinefooddelivery;

public class ExpressDelivery implements DeliveryMode {
	private static final double BASE_FARE = 60.00;
    private static final double PER_KM_RATE = 20.00;
    private static final double SURCHARGE = 50.00;  // priority charges

	@Override
	public double deliveryCharge(double distanceKm) {
		return BASE_FARE + (distanceKm * PER_KM_RATE) + SURCHARGE;
	}

}
