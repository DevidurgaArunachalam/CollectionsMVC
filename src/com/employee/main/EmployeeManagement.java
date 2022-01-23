package com.employee.main;

import java.util.Date;
import java.util.Iterator;

import com.employee.controller.EmployeeController;
import com.employee.model.Employee;
import com.employee.service.EmployeeServiceImpl;
import com.employee.view.EmployeeDetails;

   /**
   * This project describes about the Employee Management System using Collection by 
   * implementing CRUD OPERATIONS like, add employee details,view details,update
   * if needed and delete the details by providing switch case to follow the flow
   * as per user's choice. 
   * 
   * @author Devidurga Arunachalam
   */
public class EmployeeManagement extends EmployeeDetails {
    private static final EmployeeController EMPLOYEECONTROLLER = new EmployeeController();
	private static Employee employee = new Employee();
    
	public static void main(String[] args) {
	   int choice;
	   
	   /**
		 * Performs switch case function for selecting according to the  preference. 1 for adding employee details, 
		 * 2 for viewing all employee details, 3 for updating an employee detail using id, 4 for deleting details.
		 * @param args
		 */
		do {
			System.out.println(
					"\nEmployee Management System\n1.Add Employee\n2.View EmployeeList\n3.Update Employee Details\n4.Delete Employee details\n5.Exit\nEnter your choice :");
			choice = SCANNER.nextInt();

			switch (choice) {
			case 1:
				addEmployeeDetails();
				break;
			case 2:
				viewEmployeeDetails();
				break;
			case 3:
				updateEmployeeDetails();
				break;
			case 4:
				deleteEmployeeDetails();
				break;
			default:
				SCANNER.close();
				System.exit(5);
			}
		} while (choice != 0);
	}
	
	/**
	 * This method is used to add employee details as including employeeId,
	 * name of the employee, salary details,contact number, emailId and
	 *  date of birth of the employee and pass it to the controller.  
	 */
	private static void addEmployeeDetails() {
		int employeeId = EmployeeDetails.getEmployeeId();
		String employeeName = EmployeeDetails.getEmployeeName();
		String salary = EmployeeDetails.getEmployeeSalary();
		String contactNumber = EmployeeDetails.getContactNumber();
		String emailId = EmployeeDetails.getEmailId();
		Date date = EmployeeDetails.getDateOfBirth();
		Employee employee = new Employee(employeeName, salary, contactNumber, emailId ,date);
		
		EMPLOYEECONTROLLER.addEmployeeDetails(employeeId, employee);
	}
	
	/**
	 * This method is used to view the employee details.
	 */
	private static void viewEmployeeDetails() {
		EMPLOYEECONTROLLER.viewEmployeeDetails();
	}
	
	/**
	 * This method is used to delete the employee details by checking the employeeId.
	 */
	private static void deleteEmployeeDetails() {
		int employeeId = EmployeeDetails.getEmployeeId();

		EMPLOYEECONTROLLER.deleteEmployeeDetails(employeeId);
	}
	
	/**
	 * This method id used to update the employee details by using iterator and 
	 * employeeId for checking the availability of the details of the employee
	 * and then update employee details using switch case 
	 * implemetation by user choice.
	 */
	private static void updateEmployeeDetails() {
	    Iterator<Integer> iterator =EmployeeServiceImpl.EMPLOYEEDETAILS.keySet().iterator();
		 
		while (iterator.hasNext()) {
		int employeeId = EmployeeDetails.getEmployeeId();
		int employee = iterator.next();
			
				if (employee == employeeId) {
					System.out.println(
					    "Enter Your Choice To Update:\n1.Update Employee Details\n2.Update Name\n3.Update Salary\n4.Update Contact Number\n5.Update EmailId\n6.Update Date\n7.Go Back");
					int choice1 = EmployeeManagement.SCANNER.nextInt();
				   
					switch(choice1) {
				    case 1:							
				    	updateEmployee();
					    break;
					
				    case 2:
				    	updateEmployeeName();
					    break;
					
				    case 3:
				    	updateEmployeeSalary();
					    break;
					
				    case 4:
				    	updateEmployeeContactNumber();
					    break;
					   
				    case 5:
				    	updateEmployeeEmailId();
					    break;
					
				    case 6 :
				    	updateDateOfBirth();
				    	break;
				   }
				
				} else {
					System.out.println("EmployeeId Not Found!!.. Please Enter Vaild Id: ");
				}
			}
	}
	/**
	 * This method is used to update the entire employee details
	 *  by checking the employeeId  to update. 
	 */
	private static void updateEmployee() {
		int employeeId = EmployeeDetails.getEmployeeId();
		String employeeName = EmployeeDetails.getEmployeeName();
		String salary = EmployeeDetails.getEmployeeSalary();
		String contactNumber = EmployeeDetails.getContactNumber();
		String emailId = EmployeeDetails.getEmailId();
		Date date = EmployeeDetails.getDateOfBirth();
		Employee employee = new Employee(employeeName, salary, contactNumber,emailId, date);
		
		EMPLOYEECONTROLLER.updateEmployeeDetails(employeeId, employee);
	}
	
	/**
	 * This method is used to update the employee name 
	 * by checking employeeId.
	 */
	public static void updateEmployeeName() {
		int employeeId = EmployeeDetails.getEmployeeId();
		String employeeName =  EmployeeDetails.getEmployeeName();
				 
		employee.setEmployeeName(employeeName);
		EMPLOYEECONTROLLER.updateEmployeeDetails(employeeId, employee);
	}
	
	/**
	 * This method is used to update employee salary details 
	 * by checking employeeId
	 */
	public static void updateEmployeeSalary() {
		int employeeId = EmployeeDetails.getEmployeeId();
		String  salary = EmployeeDetails.getEmployeeSalary();
       
		employee.setSalary(salary);
		EMPLOYEECONTROLLER.updateEmployeeDetails(employeeId, employee);
	}
	
	/**
	 * This methodis used to update employee contact number
	 * by checking the employeeId.
	 */
	public static void updateEmployeeContactNumber() {
		int employeeId = EmployeeDetails.getEmployeeId();
		String contactNumber = EmployeeDetails.getContactNumber();
			
		employee.setContactNumber(contactNumber);
		EMPLOYEECONTROLLER.updateEmployeeDetails(employeeId, employee);
	}
	
	/**
	 * This method is used to update the employee emailId 
	 * by checking the employeeId.
	 */
	public static void updateEmployeeEmailId() {
		int employeeId = EmployeeDetails.getEmployeeId();
		String emailId = EmployeeDetails.getEmailId();
				
		employee.setEmailId(emailId);
		EMPLOYEECONTROLLER.updateEmployeeDetails(employeeId, employee);
	}
	
	/**
	 * This method is used to update employee date of birth
	 * by checking the employeeId.
	 */
	public static void updateDateOfBirth() {
		int employeeId = EmployeeDetails.getEmployeeId();
		Date date = EmployeeDetails.getDateOfBirth();
		
		employee.setDate(date);
		EMPLOYEECONTROLLER.updateEmployeeDetails(employeeId, employee);
	}
	
}