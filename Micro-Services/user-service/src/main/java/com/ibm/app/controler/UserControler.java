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

import com.ibm.app.model.User;
import com.ibm.app.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserControler {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/greet/{username}",method=RequestMethod.GET)
	public ResponseEntity<String> greetUser(@PathVariable("username") String username){
		return new ResponseEntity<String>("Well come to Rest service "+username,HttpStatus.OK);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody User user){
		userRepository.save(user);
		return new ResponseEntity<String>("User added "+user.getUsername()+" Successfully.",HttpStatus.OK);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity<String> updateUser(@RequestBody User user){
		User oldUser = userRepository.findOne(user.getId());
		oldUser.setEmail(user.getEmail());
		oldUser.setUsername(user.getUsername());
		userRepository.save(oldUser);
		return new ResponseEntity<String>("User updated "+user.getUsername()+" Successfully.",HttpStatus.OK);
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.DELETE)
	public ResponseEntity<String> removeUser(@RequestBody User user){
		User oldUser = userRepository.findOne(user.getId());
		userRepository.delete(oldUser);
		return new ResponseEntity<String>("User removed "+user.getUsername()+" Successfully.",HttpStatus.OK);
	}
	
	@RequestMapping(value="/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<User> findById(@PathVariable("id") Integer id){
		User user = userRepository.findOne(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		return new ResponseEntity<List<User>>(userRepository.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/findByName/{username}",method=RequestMethod.GET)
	public ResponseEntity<List<User>> findByUsername(@PathVariable("username") String  username){
		return new ResponseEntity<List<User>>(userRepository.findByUsername(username),HttpStatus.OK);
	}
	
}
