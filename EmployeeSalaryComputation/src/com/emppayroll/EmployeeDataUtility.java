package com.emppayroll;

public class EmployeeDataUtility {
	
	public static boolean validateName(String input) {
		if (input.matches("[a-zA-Z]+")) {
//            System.out.println("Valid name!");
            return true;
        } else {
            System.out.println("Invalid name. Please use letters only.");
            return false;
        }
	}

}
