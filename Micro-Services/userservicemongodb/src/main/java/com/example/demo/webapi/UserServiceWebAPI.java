package com.example.demo.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.UserRepositoryDAO;
import com.example.demo.domain.UserDO;

@RestController
public class UserServiceWebAPI {

	@Autowired
	private UserRepositoryDAO userRepositoryDAO;

	@PostMapping("userdo")
	public ResponseEntity<UserDO> addNewUserDO(@RequestBody UserDO userDO) {
		userRepositoryDAO.save(userDO);
		return new ResponseEntity<>(userDO, HttpStatus.CREATED);
	}

	@PostMapping("/userdo/{id}")
	public ResponseEntity<UserDO> updateExistingUserDO(@PathVariable("id") String id, @RequestBody UserDO userDO) {
		UserDO existingUserDO = userRepositoryDAO.findOne(id);
		existingUserDO.setEmail(userDO.getEmail());
		existingUserDO.setName(userDO.getName());
		userRepositoryDAO.save(userDO);
		return new ResponseEntity<>(userDO, HttpStatus.CREATED);
	}

	// http:IP:PORT/orders/123
	@GetMapping("/userdo/{id}")
	public ResponseEntity<UserDO> findExistingOrder(@PathVariable("id") String id) {
		UserDO existingUserDO = userRepositoryDAO.findOne(id);
		return new ResponseEntity<>(existingUserDO, HttpStatus.OK);

	}
	
	@DeleteMapping("/userdo/{id}")
	public ResponseEntity<String> deleteExistingOrder(@PathVariable("id") String id){
		userRepositoryDAO.delete(id);
		return new ResponseEntity<>("Removed", HttpStatus.NO_CONTENT);
/*		if (!StringUtils.isNumeric(id)) {
			orderRepository.delete(id);
			return new ResponseEntity<>("Removed", HttpStatus.NO_CONTENT);
		} else
			throw new Exception("Invalid Id");*/
	}
}
