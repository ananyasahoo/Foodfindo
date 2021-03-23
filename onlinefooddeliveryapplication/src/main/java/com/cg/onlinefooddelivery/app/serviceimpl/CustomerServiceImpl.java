
package com.cg.onlinefooddelivery.app.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlinefooddelivery.app.domain.Customer;
import com.cg.onlinefooddelivery.app.exception.ResourceNotFoundException;
import com.cg.onlinefooddelivery.app.repository.CustomerRepository;
import com.cg.onlinefooddelivery.app.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository  customerRepository;

	
	
	
	/*
	 * This method will save or Update Customer details
	 * @param customer
	 * @return Saved Customer 
	 */
	public Customer saveOrUpdate(Customer customer) 
	{
		
//		
//	    	customer.setAddress(customer.getAddress());
//	    	customer.getAddress().setCustomer(customer);
//			customer.getAddress().setArea(customer.getAddress().getArea());
//			customer.getAddress().setBuildingName(customer.getAddress().getBuildingName());
//			customer.getAddress().setStreetNo(customer.getAddress().getStreetNo());
//			customer.getAddress().setCity(customer.getAddress().getCity());
//			customer.getAddress().setState(customer.getAddress().getState());
//			customer.getAddress().setCountry(customer.getAddress().getCountry());
//			customer.getAddress().setPinCode(customer.getAddress().getPinCode());
//			
		
       	return customerRepository.save(customer);
		
	}
	
/*
 * This method is for finding all  customer details
 * @return all customer details
 */
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	
	/*
	 * This method is for finding customer details by id
	 * @param id
	 */
	public  Customer findCustomerById(int id) {
		
		Customer customer=customerRepository.findById(id);
		if(customer==null) {
			throw new ResourceNotFoundException("Invalid Customer");
		}
		return customer;
		
	}
	
	
	/*
	 * This method is for deleting the customer details by id
	 * @param id
	 */
		public void deleteCustomerById(int id) 
		{
			Customer customer=customerRepository.findById(id);
			if(customer==null) {
				throw new ResourceNotFoundException("Invalid Customer");
			}
			customerRepository.deleteById(id);
		}
}
