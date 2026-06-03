package com.emppayroll;

import java.util.HashMap;
import java.util.Map;

public class PayRollSystem {
	//list to hold added employees
	static Map<Integer, Employee> employeesRecord = new HashMap<Integer, Employee>();
	
	static{
		//initial record adding here
		employeesRecord.put(106,new PermanantEmployee(106, "Ram Mehra", Designation.SENIOR_DEV, 60000, 8));
		employeesRecord.put(102,new ContractEmployee(102, "Rajat Kapur", Designation.SENIOR_DEV, 40000, 4));
		employeesRecord.put(105,new Intern(105, "Anil Gayaki", Designation.INTERN, 6000, 3));
		employeesRecord.put(104,new Intern(104, "Soumya Gupta", Designation.INTERN, 8000, 2));
		employeesRecord.put(103,new ContractEmployee(103, "Sumit", Designation.JUNIOR_DEV, 20000, 1));
		employeesRecord.put(101, new PermanantEmployee(101, "Sumit Vyas", Designation.JUNIOR_DEV, 20000, 1));
		
		employeesRecord.forEach((id,employee) ->{
			employee.calculateSalary();
		});
	}
	
	
	public static void addEmployee(Employee e) throws DuplicateIdException {
		if(employeesRecord.containsKey(e.empId)) {
			System.out.println("Duplicate ID Found");
			throw new DuplicateIdException("Duplicate ID already Exists continue with another ID");
		}
		employeesRecord.put(e.empId, e);
		System.out.println("---------------------------");
		System.out.println("Employee Added successfully");
		System.out.println("---------------------------");
	}
	
	public static void displayEmployees() {
		if(employeesRecord.isEmpty()) {
			System.out.println("No Record of Employee Found");
			return;
		}
		System.out.println("-----Employees Records-----");
		for (Map.Entry<Integer, Employee> entry : employeesRecord.entrySet()) {
		    System.out.println(entry.getValue());
		}
		System.out.println();
	}
	
	public static void deleteEmployee(int id) throws EmployeeIdNotFoundException {
		if(!employeesRecord.containsKey(id)) {
			System.out.println("ID Not Found");
			throw new EmployeeIdNotFoundException("Employee ID not found");
		}
		employeesRecord.remove(id);
		System.out.println("-----------------------------");
		System.out.println("Employee deleted successfully");
		System.out.println("-----------------------------");
	}
}
