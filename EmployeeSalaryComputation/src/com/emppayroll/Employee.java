package com.emppayroll;

public abstract class Employee {
	protected int empId;
	protected String name;
	protected Designation designation;
	protected String role;
	protected double baseSalary;
	protected float experience;
	protected double netSalary;

	/**
	 * @param empId
	 * @param name
	 * @param designation
	 * @param salary
	 * @param experience
	 */
	public Employee(int empId, String name, Designation designation, double baseSalary, float experience) {
		super();
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.baseSalary = baseSalary;
		this.experience = experience;
	}

	abstract double calculateSalary();
	
	//concrete method to print pay slip
	public void printPaySlip() {
		System.out.println();
        System.out.println("---- Payslip for: "+ name + " ----");
        System.out.println("Employee ID : " + empId);
        System.out.println("Role        : " + this.role);
        System.out.println("Designation : " + designation);
        System.out.println("Experience  : " + experience + " years");
        System.out.println("Final Net Salary: " + netSalary+"/- Rs");
    }

	@Override
	public String toString() {
		return empId + " | " + name + " | " + designation +" | "+ role+ " | "
				+ baseSalary + "/- | " + experience + " yrs exp | " + netSalary +"/- ";
	}
	
	
}
