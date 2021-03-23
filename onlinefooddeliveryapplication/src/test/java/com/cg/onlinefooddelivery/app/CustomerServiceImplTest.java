package com.cg.onlinefooddelivery.app;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlinefooddelivery.app.domain.Address;
import com.cg.onlinefooddelivery.app.domain.Customer;
import com.cg.onlinefooddelivery.app.repository.CustomerRepository;
import com.cg.onlinefooddelivery.app.serviceimpl.CustomerServiceImpl;
@SpringBootTest
class CustomerServiceImplTest {

	@MockBean
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	
	@Test
	public void CreateCustomerForValidInput() {
		Customer customer = new Customer();
		Address address=new Address();
		customer.setId(50);
		customer.setFirstName("Shubham");
		customer.setLastName("Sahoo");
		customer.setAge(26);
		customer.setGender("Male");
		customer.setMobileNumber("7887893221");
		
	customer.setAddress(address);
		address.setId(51);
		address.setBuildingName("Bhagawan palace");
		address.setStreetNo("231");
		address.setArea("HDFC Lane");
		address.setCity("Puri");
	    address.setCountry("India");
	  address.setState("Odisha");
	  address.setPinCode("752021");
		
		customer.setEmail("shubhamsahoo@gmail.com");
		
		Mockito.when( customerRepository.save(customer)).thenReturn(customer);
		
		assertEquals(customer ,customerServiceImpl.saveOrUpdate(customer));
		
	}
	
	@Test
	public void getCustomerDetailsByInvalidId() {
		
	Customer customer = new Customer();
	Address address=new Address();
	customer.setId(50);
	customer.setFirstName("Shubham");
	customer.setLastName("Sahoo");
	customer.setAge(26);
	customer.setGender("Male");
	customer.setMobileNumber("7887893221");
	
    customer.setAddress(address);
	address.setId(51);
	address.setBuildingName("Bhagawan palace");
	address.setStreetNo("231");
	address.setArea("HDFC Lane");
	address.setCity("Puri");
    address.setCountry("India");
    address.setState("Odisha");
    address.setPinCode("752021");
	customer.setEmail("shubhamsahoo@gmail.com");
	
	when(customerRepository.findById(53)).thenReturn(customer);
	 Customer details=customerServiceImpl.findCustomerById(53);
	 assertEquals(customer,details);
	}
	

	@Test
	public void getCustomerDetailsByValidId() {
		
	Customer customer = new Customer();
	Address address=new Address();
	customer.setId(50);
	customer.setFirstName("Shubham");
	customer.setLastName("Sahoo");
	customer.setAge(26);
	customer.setGender("Male");
	customer.setMobileNumber("7887893221");
	
    customer.setAddress(address);
	address.setId(51);
	address.setBuildingName("Bhagawan palace");
	address.setStreetNo("231");
	address.setArea("HDFC Lane");
	address.setCity("Puri");
    address.setCountry("India");
    address.setState("Odisha");
    address.setPinCode("752021");
	customer.setEmail("shubhamsahoo@gmail.com");
	
	when(customerRepository.findById(50)).thenReturn(customer);
	 Customer details=customerServiceImpl.findCustomerById(50);
	 assertEquals(customer,details);
	}


}
