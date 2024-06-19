package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public ArrayList<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		 ArrayList<Customer>  customerList= new ArrayList<Customer>();
		 CustomerDAO customerDAO= new CustomerDAO();
		 Connection connection =customerDAO.getConnection();
		 customerList= customerDAO.getAllCustomers(connection);
		return customerList;
	}

	@Override
	public int insertIntoCustomer(Customer customer) {
		int result = 0;
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        result = customerDAO.insertCustomer(connection, customer);
        customerDAO.closeConnection(connection);
        return result;
	}


	@Override
	public int updateCustomer(int customerCode, int attributeChoice, String newValue) {
	    int result = 0;
	    CustomerDAO customerDAO = new CustomerDAO();
	    Connection connection = customerDAO.getConnection();
	    result = customerDAO.updateCustomer(connection, customerCode, attributeChoice, newValue);
	    customerDAO.closeConnection(connection);
	    return result;
	}


}
