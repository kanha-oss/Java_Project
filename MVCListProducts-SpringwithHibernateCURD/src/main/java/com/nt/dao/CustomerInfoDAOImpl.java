package com.nt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Customer;

@Repository("dao")
@Transactional
public class CustomerInfoDAOImpl implements CustomerInfoDAO {
	
	@Autowired
	private SessionFactory sf;

	@Override
	
	public List<Customer> getAllCustomers()  {
			 Session session = sf.openSession();
		/*
		 * Transaction trans = session.beginTransaction(); trans.begin();
		 */
			 List <Customer> custList = session.createQuery("from Customer").list();
			 //trans.commit();
			 session.close();
			 return custList;
					
	}//method

	@Override
	public Customer getCustomerByCno(int cno) {
		Session ses=sf.openSession();
		Customer ct=(Customer) ses.get(Customer.class, cno);
		return ct;
	}

	@Override
	public void updateCustomerByNo(Customer ct) {
		Session ses=sf.openSession();
		ses.update(ct);
		
	}

	@Override
	public void deleteCustomerByNo(int cno) {
		
	Session ses=sf.openSession();
		ses.createQuery("DELETE FROM Customer WHERE cno = "+cno).executeUpdate();
		
	}
	
	/*
	 * public void setSessionFactory(SessionFactory sf){ this.sf = sf; }
	 */
	
	
	

	
	

	

}//class

