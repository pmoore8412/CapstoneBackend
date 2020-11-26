package com.mooremaking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mooremaking.object.Posts;
import com.mooremaking.repository.PostRepository;

@CrossOrigin
@RestController
public class PostController {

	@Autowired
	PostRepository postRepo;
	
	@RequestMapping(value="/submitPost", 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, 
			method=RequestMethod.POST)
	public void submitUserDetails(@RequestBody Posts post) {
		
		postRepo.save(post);
	}
	
}
