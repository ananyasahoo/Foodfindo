package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinefooddelivery.app.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address , Integer>  {
 
public Address findById(int id);
}
