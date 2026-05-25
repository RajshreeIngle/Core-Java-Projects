package com.emppayroll;

//enum to create final multiplier for salary calculation.
public enum Designation {
	INTERN(1.0),
	JUNIOR_DEV(1.2),
	SENIOR_DEV(1.5),
	MANAGER(2.2);

    private final double multiplier;
    
    Designation(double multiplier){ 
    	this.multiplier = multiplier; 
    }
    
    public double getMultiplier() {
    	return multiplier; 
    }

}
