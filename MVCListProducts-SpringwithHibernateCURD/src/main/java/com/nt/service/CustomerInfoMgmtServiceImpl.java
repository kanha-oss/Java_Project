package com.nt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.CustomerInfoDAO;
import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;

@Service("serv")
//@Transactional(propagation =Propagation.REQUIRED  ,readOnly = true)
public class CustomerInfoMgmtServiceImpl implements CustomerInfoMgmtService {
	
	@Autowired
	private  CustomerInfoDAO dao;
    
	@Override
	public List<Customer> fetchAllCustomers() {
		return dao.getAllCustomers();
	
	}//method



	@Override
	public Customer fetchCustomerByCno(int cno) {
		
		return dao.getCustomerByCno(cno);
		
	}
	
	@Override
	public void modifyCustomerByNo(CustomerDTO dto) {
		Customer ct=new Customer();
		ct.setCno(dto.getCno());
		ct.setCname(dto.getCname());
		ct.setCadd(dto.getCadd());
		ct.setMobileNo(dto.getMobileNo());
		ct.setBillAmt(dto.getBillAmt());
		dao.updateCustomerByNo(ct);
		
	
	}
	
	//this method for delete cutomer data
	@Override
	public void removeCustomerByNo(int cno) {
	
		//use DAO
		dao.deleteCustomerByNo(cno);
	
	}

}//class
