package com.mooremaking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mooremaking.object.Users;
import com.mooremaking.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value="/submitUserDetails", 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, 
			method=RequestMethod.POST)
	public void submitUserDetails(@RequestBody Users user)
	{
		userRepo.save(user);
	}

	@RequestMapping(value="/findUserById",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Optional<Users>> findStudent(String email)
	{
		return new ResponseEntity<>(userRepo.findById(email), HttpStatus.OK);
	}
	
	@RequestMapping(value="/listUser",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Users>> listStudent()
	{
		
		return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/userLogin",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Optional<Users>> login(@RequestBody Users user) 
	{
		
		Optional<Users> userDB = userRepo.findById(user.getEmail());
		
		if(userDB.isPresent() && userDB.get().getPassword().equals(user.getPassword()))
			return new ResponseEntity<>(userDB, HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	
}
