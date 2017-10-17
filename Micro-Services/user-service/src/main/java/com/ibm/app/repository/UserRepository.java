package com.ibm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibm.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public List<User> findByUsername(String username); 
}
