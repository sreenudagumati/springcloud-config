package com.ibm.app.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.app.model.UserAddress;
import com.ibm.app.repository.UserAddressRepository;

@RestController
@RequestMapping("/userAddress")
public class UserAddressControler {

	@Autowired
	UserAddressRepository userAddressRepository;
	
	
	@RequestMapping(value="/saveUserAddress",method=RequestMethod.POST)
	public ResponseEntity<String> saveUserAddress(@RequestBody UserAddress userAddress){
		userAddressRepository.save(userAddress);
		return new ResponseEntity<String>("User address saved.",HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateUserAddress",method=RequestMethod.POST)
	public ResponseEntity<String> updateUserAddress(@RequestBody UserAddress userAddress){
		userAddressRepository.save(userAddress);
		return new ResponseEntity<String>("User address updated.",HttpStatus.OK);
	}
	
	@RequestMapping(value="/removeUserAddress",method=RequestMethod.POST)
	public ResponseEntity<String> removeUserAddress(@RequestBody UserAddress userAddress){
		userAddressRepository.save(userAddress);
		return new ResponseEntity<String>("User address removed.",HttpStatus.OK);
	}
	
	@RequestMapping(value="/findAllUserAddress/{userid}",method=RequestMethod.POST)
	public ResponseEntity<List<UserAddress>> findAllUserAddress(@PathVariable("userid") String userid){
		List<UserAddress> userAddressList  = userAddressRepository.findByUserid(userid);
		return new ResponseEntity<List<UserAddress>>(userAddressList,HttpStatus.OK);
	}
}
