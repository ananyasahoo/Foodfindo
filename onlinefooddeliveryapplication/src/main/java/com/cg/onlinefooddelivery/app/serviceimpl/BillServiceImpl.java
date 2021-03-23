package com.cg.onlinefooddelivery.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinefooddelivery.app.domain.Bill;
import com.cg.onlinefooddelivery.app.domain.Item;
import com.cg.onlinefooddelivery.app.exception.ResourceNotFoundException;
import com.cg.onlinefooddelivery.app.repository.BillRepository;
import com.cg.onlinefooddelivery.app.service.BillService;


@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	@Override
	public List<Bill> getAllBills() {
		return  billRepository.findAll();
	}

	@Override
	public Bill getBillById(int billId) {
		return billRepository.getBillById(billId);
		
	}

	@Override
	public Bill saveorUpdate(Bill bill) {
		
		return billRepository.save(bill);
	}

	@Override
	public void deleteBill(int billId) {
		Bill bill=getBillById(billId);
		if(bill==null)
		{
			throw new ResourceNotFoundException("doesn't exis");
		}
		 billRepository.deleteById(billId);
		
	}

	
	@Override
	public double calculateBill(List<Item> items) {
		double sum=0;
		for(Item item:items)
			{
				sum=sum+(item.getCost()*item.getQuantity());
				System.out.println(sum);
				
			}
		return sum;
			
		
	}
	


	
}
