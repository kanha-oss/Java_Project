package com.nt.service;

import java.util.List;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;


public interface CustomerInfoMgmtService {
	
	//this method get/show all customer details
	public  List<Customer> fetchAllCustomers() ; 
	
	//this method for get only 1 customer details
	public Customer fetchCustomerByCno(int cno);
	
	//this method update the customer details
	public  void modifyCustomerByNo(CustomerDTO dto);
	
	//this method for delete cutomer data
	public  void  removeCustomerByNo(int cno);

}
