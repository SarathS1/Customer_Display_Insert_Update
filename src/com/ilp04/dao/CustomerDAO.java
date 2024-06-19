package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {
    
//	GET CONNECTION
	 public Connection getConnection()
	 {  
		 String connectionURL="jdbc:mysql://localhost:3306/bankdb?useSSL=false";
		 String userName = "root";
		 String password = "experion@123";
		 Connection connection=null;
		 try {
			connection=DriverManager.getConnection(connectionURL,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return connection;
	 }
	
//	CLOSE CONNECTION
	 public 	Connection closeConnection(Connection connection )
	 {
		 try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return connection;
	 }
//	GET ALL CUSTOMER DETAILS
	 
	 public ArrayList<Customer> getAllCustomers(Connection connection){
		 ArrayList<Customer>  customerList= new ArrayList<Customer>();
		 Statement statement;
		 ResultSet resultSet;
	   
		 try {
			 statement=connection.createStatement();
			resultSet=statement.executeQuery("select * from customer");
			while(resultSet.next())
			{
				int customerCode=resultSet.getInt(1);
				String customerFirstname=resultSet.getString(2);
				String customerLastname=resultSet.getString(3);
				String address=resultSet.getString(4);
				long phnNumber=resultSet.getLong(5);
				long aadharNo=resultSet.getLong(6);
				Customer customer = new Customer(customerCode,customerFirstname,customerLastname,address,phnNumber,aadharNo);
				customerList.add(customer);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return customerList;
	 }
//	 Insert customers
	 public int insertCustomer(Connection connection, Customer customer) {
		    int result = 0;
		    String insertQuery = "insert into customer(customer_firstname,customer_lastname,address,phone_number,aadhaar_number) VALUES ('" 
		                         + customer.getCustomerFirstname() + "', '"
		                         + customer.getCustomerLastname() + "', '"
		                         + customer.getAddress() + "', "
		                         + customer.getPhnNumber() + ", "
		                         + customer.getAadharNo() + ")";
		    try {
		        Statement statement = connection.createStatement();
		        result = statement.executeUpdate(insertQuery);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return result;
		}
	 
//	 update customer
//	 get customer by code
	 public Customer getCustomerByCode(Connection connection, int customerCode) {
		    Customer customer = null;
		    String selectQuery = "SELECT * FROM customer WHERE customer_code = " + customerCode;
		    try {
		        Statement statement = connection.createStatement();
		        ResultSet resultSet = statement.executeQuery(selectQuery);
		        if (resultSet.next()) {
		            String customerFirstname = resultSet.getString(2);
		            String customerLastname = resultSet.getString(3);
		            String address = resultSet.getString(4);
		            long phnNumber = resultSet.getLong(5);
		            long aadharNo = resultSet.getLong(6);
		            customer = new Customer(customerCode, customerFirstname, customerLastname, address, phnNumber, aadharNo);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return customer;
		}

//eo
	 public int updateCustomer(Connection connection, int customerCode, int attributeChoice, String newValue) {
		    int result = 0;
		    Customer customer = getCustomerByCode(connection, customerCode);
		    if (customer == null) {
		        System.out.println("Customer not found");
		        return result;
		    }

		    String updateQuery = null;
		    switch (attributeChoice) {
		        case 1:
		            updateQuery = "UPDATE customer SET customer_firstname = '" + newValue + "' WHERE customer_code = " + customerCode;
		            break;
		        case 2:
		            updateQuery = "UPDATE customer SET  customer_lastname = '" + newValue + "' WHERE customer_code = " + customerCode;
		            break;
		        case 3:
		            updateQuery = "UPDATE customer SET address = '" + newValue + "' WHERE customer_code = " + customerCode;
		            break;
		        case 4:
		            updateQuery = "UPDATE customer SET phone_number = " + Long.parseLong(newValue) + " WHERE customer_code = " + customerCode;
		            break;
		        case 5:
		            updateQuery = "UPDATE customer SET aadhaar_number = " + Long.parseLong(newValue) + " WHERE customer_code = " + customerCode;
		            break;
		        default:
		            System.out.println("Invalid choice");
		            return result;
		    }

		    try {
		        Statement statement = connection.createStatement();
		        result = statement.executeUpdate(updateQuery);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return result;
		}

//	 eo update
}
