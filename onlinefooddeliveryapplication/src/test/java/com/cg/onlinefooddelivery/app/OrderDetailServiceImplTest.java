package com.cg.onlinefooddelivery.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlinefooddelivery.app.domain.OrderDetail;
import com.cg.onlinefooddelivery.app.repository.OrderDetailRepository;
import com.cg.onlinefooddelivery.app.serviceimpl.OrderDetailServiceImpl;
@SpringBootTest
class OrderDetailServiceImplTest {

	@Autowired
	OrderDetailServiceImpl orderDetailServiceImpl;
	
	
	@MockBean
	OrderDetailRepository orderRepository;
	
	@Test
	public void testSaveOrUpdateTest() {
		OrderDetail order=new OrderDetail();
		order.setId(12);
		order.setOrderNo("OR01");
		order.setOrderStatus("placed");
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order,orderDetailServiceImpl.SaveOrUpdate(order));
	}
	@Test
	public void getOrderByIdTest() {
		OrderDetail order=new OrderDetail();
		when(orderRepository.findById(75)).thenReturn(order);
		assertEquals(order,orderDetailServiceImpl.findById(75));
	}
        @Test
        public void getAllOrdersTest(){
         OrderDetail order=new OrderDetail();
          order.setId(13);
          order.setOrderNo("OD02");
          order.setOrderStatus("pending");
         List<OrderDetail> orderlist=new ArrayList<>();
         orderlist.add(order);
         when(orderRepository.findAll()).thenReturn(orderlist);
         assertThat(orderDetailServiceImpl.getAllOrderDetails()).isEqualTo(orderlist);
           }
     
	

}



