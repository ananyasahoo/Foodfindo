package com.cg.onlinefooddelivery.app.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinefooddelivery.app.domain.Customer;
import com.cg.onlinefooddelivery.app.serviceimpl.CustomerServiceImpl;
import com.cg.onlinefooddelivery.app.serviceimpl.MapValidationServiceImpl;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@Autowired
	private MapValidationServiceImpl mapValidationErrorService;
	
	@PostMapping("/add")
	public ResponseEntity<?> createNewCustomer(@Valid @RequestBody Customer customer ,BindingResult result) {
		ResponseEntity<?> errorMap= mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		 Customer custom=customerService.saveOrUpdate(customer);
		return new  ResponseEntity<Customer>(custom,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> getCustomerById(int id){
		Customer custm= customerService.findCustomerById(id);
	return new ResponseEntity<Customer>(custm ,HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	public Iterable<Customer> getAllCustomer(){
		  return customerService.getAllCustomers();
	  }
	
	@DeleteMapping("/delete/{id}")
	 public  ResponseEntity<?> deleteById(@PathVariable int id){
	  customerService.deleteCustomerById(id);
	return new  ResponseEntity<String>("Customer deleted" , HttpStatus.OK);
	
	}
}
