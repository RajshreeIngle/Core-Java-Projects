package com.emppayroll;

public class ContractEmployee extends Employee {

	public ContractEmployee(int empId, String name, Designation designation, double baseSalary, float experience) {
		super(empId, name, designation, baseSalary, experience);
		this.role = "Contractual";
	}

	@Override
	double calculateSalary() {
		double roleSalary = baseSalary * designation.getMultiplier();//..... Base calculation using designation multiplier
        double experienceBonus = experience * 700;				//.....Experience-based calculation (e.g., $1000 bonus per year of experience)
        double grossSalary = roleSalary + experienceBonus;   	//.....Gross Earnings
        double tax = grossSalary * 0.10;   						//.....tax deductions 10% 
        this.netSalary = grossSalary-tax;
		return this.netSalary;
	}

}
