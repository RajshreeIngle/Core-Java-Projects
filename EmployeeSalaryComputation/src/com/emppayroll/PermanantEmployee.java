package com.emppayroll;

public class PermanantEmployee extends Employee {
		
	public PermanantEmployee(int empId, String name, Designation designation, double baseSalary, float experience) {
		super(empId, name, designation, baseSalary, experience);
		this.role ="Permanent";
	}

	@Override
	double calculateSalary() {
        double roleSalary = baseSalary * designation.getMultiplier();//..... Base calculation using designation multiplier
        double experienceBonus = experience * 1000;				//.....Experience-based calculation (e.g., $1000 bonus per year of experience)
        double grossSalary = roleSalary + experienceBonus;   	//.....Gross Earnings
        double tax = grossSalary * 0.10;   						//.....tax deductions 10% 
        this.netSalary = grossSalary-tax;
		return this.netSalary;
	}
	
}
