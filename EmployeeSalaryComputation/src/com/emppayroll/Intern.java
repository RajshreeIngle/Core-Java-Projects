package com.emppayroll;

public class Intern extends Employee {
	
	public Intern(int empId, String name, Designation designation, double baseSalary, float experience) {
		super(empId, name, designation, baseSalary, experience);
		this.role = "Internship";
	}

	@Override
	double calculateSalary() {
		double roleSalary = baseSalary * designation.getMultiplier();//..... Base calculation using designation multiplier
        double experienceBonus = (experience/12) * 200;				//.....Experience-based calculation (e.g., $1000 bonus per year of experience)
        double grossSalary = roleSalary + experienceBonus;   	//.....Gross Earnings
        double tax = grossSalary * 0.10;   						//.....tax deductions 10% 
        this.netSalary = grossSalary-tax;
        this.netSalary = Math.round(this.netSalary *100.00) /100.00;
		return this.netSalary;
	}

	@Override
	public void printPaySlip() {
		System.out.println("---- Payslip for: "+ name + " ----");
        System.out.println("Employee ID      : " + empId);
        System.out.println("Role             : " + this.role);
        System.out.println("Designation      : " + designation);
        System.out.println("Experience       : " + experience +"months");
        System.out.println("Final Net Stipend: " + netSalary+"/- Rs");
	}

	@Override
	public String toString() {
		return empId + " | " + name + " | " + designation +" | "+ role+ " | "
				+ baseSalary + "/- | " + experience + " months exp | " + netSalary +"/- ";
	}
	
	

}
