package com.ilp04.service;

import java.util.ArrayList;

import com.ilp04.entity.Customer;

public interface CustomerService {
   public ArrayList<Customer> getAllCustomer();
   public int insertIntoCustomer(Customer customer);
//   public int updateCustomer(Customer customer);
   public int updateCustomer(int customerCode, int attributeChoice, String newValue);

}
