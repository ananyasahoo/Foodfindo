package com.cg.onlinefooddelivery.app.serviceimpl;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinefooddelivery.app.domain.Bill;
import com.cg.onlinefooddelivery.app.domain.FoodCart;
import com.cg.onlinefooddelivery.app.domain.Item;
import com.cg.onlinefooddelivery.app.domain.OrderDetail;
import com.cg.onlinefooddelivery.app.exception.ResourceNotFoundException;
import com.cg.onlinefooddelivery.app.repository.OrderDetailRepository;
import com.cg.onlinefooddelivery.app.service.OrderDetailService;
/**
 * this OrderDetailService class is used for performing all business related operations
 * @author sweta
 *
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailRepository orderRepository;
	@Autowired
	private BillServiceImpl billServiceImpl;
	
	
	public OrderDetail SaveOrUpdate(OrderDetail orderDetail)  {
		
		
		//String orderNo=orderDetail.getOrderNo();
		//orderDetail.setOrderNo("OD"+orderNo);
		if(orderDetail.getOrderStatus().equals("placed"))
		{
			
			FoodCart cart=orderDetail.getCart();
			Bill bill=new Bill();
			bill.setBillDate(new Date());
			List<Item> items=cart.getItemList();
			double sum=billServiceImpl.calculateBill(items);
			bill.setBillDate(new Date());
			bill.setTotalCost(sum);
			bill.setUpdated_At(new Date());
			billServiceImpl.saveorUpdate(bill);
		}
		return orderRepository.save(orderDetail);
		
				
		
	}
	
	public List<OrderDetail> getAllOrderDetails(){
		return orderRepository.findAll();
	}
	
	public void deleteOrderDetailsById(int id)  {
		OrderDetail order=orderRepository.findById(id);
		if(order==null) {
			throw new ResourceNotFoundException("Order Id doesn't exists");
		}
	  orderRepository.deleteById(id);
	}

	@Override
	public OrderDetail findById(int id) {
	OrderDetail order=orderRepository.findById(id);
	if(order==null) {
		throw new ResourceNotFoundException("Order Id doesn't exists");
	}
		return order;
	}

	
}
