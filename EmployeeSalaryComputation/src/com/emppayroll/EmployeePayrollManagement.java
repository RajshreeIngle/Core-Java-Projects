package com.emppayroll;

import java.util.Map;
import java.util.Scanner;

public class EmployeePayrollManagement {

	public static void main(String[] args) {

		System.out.println("-----EMPLOYEE PAYROLL CALCULATION SYSTEM-----");
		System.out.println();
		//declaration of fields
		Employee employee = null;
		int id;
		String name;
		int role;
        float exp ;
        double base;
        Designation designation;
		
		Scanner scanner = new Scanner(System.in);
		int exitSystem=1;
		while(exitSystem !=0) {
			System.out.println("Enter the service number:");
			System.out.println("1.See Employee Records | 2.Add Employee | 3.Delete Employee | 4.Print PaySlip | 0.ExitSystem");
			int service = scanner.nextInt();
			scanner.nextLine();
			switch(service) {
			case 0:
				exitSystem = 0;
				break;
			case 1:
				PayRollSystem.displayEmployees();
				break;
			case 2:
		      /*
		       * TODO implement input validation and checks here
		       */
				System.out.print("Enter Employee ID: ");
		        id = scanner.nextInt();
		        scanner.nextLine();
		        System.out.print("Enter Employee Name: ");
		        name = scanner.nextLine().trim();
		        while(!EmployeeDataUtility.validateName(name)) {
		        	System.out.print("Enter Employee Name: ");
			        name = scanner.nextLine().trim();
		        }
		        System.out.print("Enter Role of Employee (1.Intern, 2.Permanent 3.Contractual): ");
		        role = scanner.nextInt();
		
		        int des =1; //default junior dev
		        //If role is intern - its an intern employee with designation as intern
		        if(role != 1) {
		        	System.out.print("Enter Designation (1.JUNIOR_DEVELOPER , 2.SENIOR_DEVELOPER, 3.MANAGER ): ");
			        des = scanner.nextInt();
			        scanner.nextLine();
			        System.out.print("Enter year of Experience: ");
			        exp = scanner.nextInt();
			        scanner.nextLine();
			        System.out.print("Enter Base Salary: ");
			        base = scanner.nextDouble();
			        scanner.nextLine();
		        }else {
		        	System.out.print("Enter months of Experience: ");
			        exp = scanner.nextInt();
			        scanner.nextLine();
			        System.out.print("Enter Stipend: ");
			        base = scanner.nextDouble();
			        scanner.nextLine();
		        	designation = Designation.INTERN;
		        }
		        
		        switch(des) {
		        case 1:
		        	designation = Designation.JUNIOR_DEV;
		        	break;
		        case 2:
		        	designation = Designation.SENIOR_DEV;
		        	break;
		        case 3:
		        	designation = Designation.MANAGER;
		        	break;
		        default:
		        	System.out.println("Invalid Selection Default set to JUNIOR_DEVELOPER");
		        	designation = Designation.JUNIOR_DEV;
		        	break;
		        }
		        
		        switch(role) {
		        case 1:
		        	employee = new Intern(id, name,designation, base, exp );
		        	break;
		        case 2:
		        	employee = new PermanantEmployee(id, name, designation, base, exp);
		        	break;
		        case 3:
		        	employee = new ContractEmployee(id, name, designation, base, exp);
		        	break;
		        default:
		        	System.out.println("Invalid Role Selected please try again");
		        	break;	
		        }
		        employee.calculateSalary();
		        try {
		        	PayRollSystem.addEmployee(employee);
		        }catch(DuplicateIdException e) {
		        	System.out.println(e);
		        }
		        
		        System.out.println();
			    break;
			case 3:
				System.out.print("Enter Employee ID you want to DELETE: ");
		        int e_id = scanner.nextInt();
		        scanner.nextLine();
		        try {
		        	PayRollSystem.deleteEmployee(e_id);
		        }catch(EmployeeIdNotFoundException e) {
		        	System.out.println(e);
		        }
		        break;
			case 4:
				System.out.print("Enter Employee ID to print pay slip: ");
		        int empID = scanner.nextInt();
		        scanner.nextLine();
		        try {
		        	if (!PayRollSystem.employeesRecord.containsKey(empID)) {
		        	    throw new EmployeeIdNotFoundException("Employee ID not found");
		        	}
		        	PayRollSystem.employeesRecord.get(empID).printPaySlip();
		        }catch(EmployeeIdNotFoundException e) {
		        	System.out.println(e);
		        }
		        break;
		    default:
		    	System.out.println("Invalid selection. Try Again");
		    	break;
		    }
			System.out.println();
		}
		scanner.close();

		System.out.println("Exited!");
		
	}
}

