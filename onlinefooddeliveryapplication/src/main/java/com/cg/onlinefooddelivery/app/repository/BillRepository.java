package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinefooddelivery.app.domain.Bill;

public interface BillRepository extends JpaRepository<Bill,Integer>
{

	public Bill getBillById(int billId);
	

}
