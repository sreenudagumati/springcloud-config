package com.ibm.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.app.model.UserAddress;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer>{
	
	public List<UserAddress> findByUserid(String userid); 
	
}
