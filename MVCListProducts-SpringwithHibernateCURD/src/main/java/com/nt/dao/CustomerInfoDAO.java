package com.nt.dao;

import java.util.List;

import com.nt.entity.Customer;




public interface CustomerInfoDAO {
	
	//this method get/show all customer detail
	public  List<Customer>  getAllCustomers();
	
	//this method for get only 1 customer details
	public  Customer  getCustomerByCno(int cno);
	
	//this method update the customer details
	public   void   updateCustomerByNo(Customer ct);
	
	//this method for delete cutomer data
	public   void  deleteCustomerByNo(int cno);
}
