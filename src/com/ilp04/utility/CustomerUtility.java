package com.ilp04.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;

public class CustomerUtility {

	public static void main(String[] args) {
		
	Scanner sc =new Scanner(System.in);
	
	
	char goToMainMenu;
	// TODO Auto-generated method stub
	do {
	System.out.println("1.Display all customers 2.Insert customer 3.Update Customer");
	int input =sc.nextInt();
	switch(input) {
	case 1:getAllCustomer();
	       break;
	case 2:insertNewCustomer();
	       break;
	case 3:updateExistingCustomer();
	       break;
	default:System.out.println("Invalid Input");      
		
	}
	System.out.println("Go to main menu(y/n)");
	goToMainMenu=sc.next().charAt(0);

	}while(goToMainMenu=='Y'||goToMainMenu=='y');
       
	}
  
	private static void getAllCustomer() {
		
		CustomerService customerService= new CustomerServiceImpl();
		ArrayList<Customer> customerList= customerService.getAllCustomer();
//		print the details of customer list
		for(Customer customer:customerList) {
			System.out.println();
			System.out.print(customer.getCustomerCode()+" ");
			System.out.print(customer.getCustomerFirstname()+ " ");
			System.out.print(customer.getCustomerLastname()+ " ");
			System.out.print(customer.getAddress()+ " ");
			System.out.print(customer.getPhnNumber()+ " ");
			System.out.print(customer.getAadharNo()+ " ");
			System.out.println();
		
			
			
		}
	}
	private static void insertNewCustomer() {
        CustomerService customerService = new CustomerServiceImpl();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the customer Firstname: ");
        String Fname= sc.nextLine();
        System.out.println("Enter the customer Lastname: ");
        String Lname= sc.nextLine();
        System.out.println("Enter the customer Address: ");
        String address= sc.nextLine();
        System.out.println("Enter the customer Phone Number: ");
        long phno= sc.nextLong();
        System.out.println("Enter the customer Aadhaar: ");
        long aadhar= sc.nextLong();
        
       
        Customer newCustomer = new Customer( Fname, Lname, address, phno,aadhar);
        int result = customerService.insertIntoCustomer(newCustomer);
        if (result > 0) {
            System.out.println("Customer inserted successfully!");
        } else {
            System.out.println("Failed to insert customer.");
        }
    }
//	update
	private static void updateExistingCustomer() {
	        Scanner scanner = new Scanner(System.in);
	        CustomerService customerService = new CustomerServiceImpl();

	        System.out.print("Enter customer code to update: ");
	        int customerCode = scanner.nextInt();

	        System.out.println("Select the attribute to update:");
	        System.out.println("1. First Name");
	        System.out.println("2. Last Name");
	        System.out.println("3. Address");
	        System.out.println("4. Phone Number");
	        System.out.println("5. Aadhar Number");
	        int attributeChoice = scanner.nextInt();
	        scanner.nextLine();  // Consume the newline character

	        System.out.print("Enter new value: ");
	        String newValue = scanner.nextLine();

	        int result = customerService.updateCustomer(customerCode, attributeChoice, newValue);
	        if (result > 0) {
	            System.out.println("Customer updated successfully!");
	        } else {
	            System.out.println("Failed to update customer.");
	        }
	        
	       
	    }
        
	
	
	
//	eo update
	
}
