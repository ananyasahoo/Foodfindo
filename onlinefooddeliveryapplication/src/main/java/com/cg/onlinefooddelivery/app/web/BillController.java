package com.cg.onlinefooddelivery.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinefooddelivery.app.domain.Bill;
import com.cg.onlinefooddelivery.app.service.BillService;
import com.cg.onlinefooddelivery.app.serviceimpl.MapValidationServiceImpl;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	@Autowired
	private MapValidationServiceImpl mapValidationServiceImpl;
	
	@GetMapping("/viewBill/{bill_id}")
	public ResponseEntity<?> getBillById(@PathVariable int bill_id) {
		Bill bill= billService.getBillById(bill_id);
		return new ResponseEntity<Bill>(bill,HttpStatus.OK);
	
	}
	
	
	
	

	
}
