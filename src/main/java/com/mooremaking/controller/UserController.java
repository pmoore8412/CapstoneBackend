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

import com.mooremaking.config.WebUtils;
import com.mooremaking.object.Users;
import com.mooremaking.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	WebUtils webUtils;
	
	
	
	@RequestMapping(value="/sendMail",  
			produces=MediaType.APPLICATION_JSON_VALUE, 
			method=RequestMethod.POST)
	public void sendMail(String from, String msg, String subject)
	{
		webUtils.sendMail("simplymooremaking@gmail.com", msg, subject + "-" + from);
	}
	
	@RequestMapping(value="/submitUserDetails", 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, 
			method=RequestMethod.POST)
	public void submitUserDetails(@RequestBody Users user)
	{
		userRepo.save(user);
	}
	
	@RequestMapping(value="/updateUserDetails", 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, 
			method=RequestMethod.POST)
	public void updateUser(@RequestBody Users user)
	{
		Users temp = new Users();
		if(userRepo.findById(user.getEmail()) != null) {
			if(user.getEmail().length() !=0)
				temp.setEmail(user.getEmail());
			if(user.getPassword().length() != 0)
				temp.setPassword(user.getPassword());
			if(user.getUserName().length() != 0)
				temp.setUserName(user.getUserName());
			temp.setRole("user");
			temp.setEmailOptIn(false);
			
			user = temp;
		}
		userRepo.save(user);
	}
	
	@RequestMapping(value="/deleteUser", 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, 
			method=RequestMethod.POST)
	public void deleteUser(@RequestBody String email)
	{

		userRepo.deleteById(email);
	}

	@RequestMapping(value="/findUser",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Optional<Users>> findUser(String email)
	{
		return new ResponseEntity<>(userRepo.findById(email), HttpStatus.OK);
	}
	
	@RequestMapping(value="/listUser",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Users>> listUser()
	{
		
		return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/userLogin",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Optional<Users>> userLogin(@RequestBody Users user) 
	{
		Optional<Users> userDB = userRepo.findById(user.getEmail());
		
		if(userDB.isPresent() && userDB.get().getPassword().equals(user.getPassword()))
			return new ResponseEntity<>(userDB, HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	
}
