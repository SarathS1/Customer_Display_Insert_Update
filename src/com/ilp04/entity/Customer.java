package com.ilp04.entity;

public class Customer {
    private int customerCode;
    private String customerFirstname;
    private String customerLastname;
    private String address;
    private long phnNumber;
    private long aadharNo;
	public Customer(int customerCode, String customerFirstname, String customerLastname, String address, long phnNumber,
			long aadharNo) {
		super();
		this.customerCode = customerCode;
		this.customerFirstname = customerFirstname;
		this.customerLastname = customerLastname;
		this.address = address;
		this.phnNumber = phnNumber;
		this.aadharNo = aadharNo;
	}
	public Customer(String fname, String lname, String address2, long phno, long aadhar) {
		this.customerFirstname = fname;
		this.customerLastname = lname;
		this.address = address2;
		this.phnNumber = phno;
		this.aadharNo = aadhar;
		
		// TODO Auto-generated constructor stub
	}
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerFirstname() {
		return customerFirstname;
	}
	public void setCustomerFirstname(String customerFirstname) {
		this.customerFirstname = customerFirstname;
	}
	public String getCustomerLastname() {
		return customerLastname;
	}
	public void setCustomerLastname(String customerLastname) {
		this.customerLastname = customerLastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhnNumber() {
		return phnNumber;
	}
	public void setPhnNumber(long phnNumber) {
		this.phnNumber = phnNumber;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
    
}
