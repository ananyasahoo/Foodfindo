package com.cg.onlinefooddelivery.app.service;

import java.util.List;



import com.cg.onlinefooddelivery.app.domain.Bill;
import com.cg.onlinefooddelivery.app.domain.Item;


public interface BillService {

	public List<Bill> getAllBills();

	public Bill saveorUpdate(Bill bill);

	public void deleteBill(int billId);

	public Bill getBillById(int billId);
	
	

	//public double calculateBill(List<Item> items);

	

	public double calculateBill(List<Item> items);
	

}
