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
	public void submitPost(@RequestBody Posts post) {
		System.out.println("post submited");
		postRepo.save(post);
	}
	
	@RequestMapping(value="/updatePost", 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, 
			method=RequestMethod.POST)
	public void updatePost(@RequestBody Posts post) {
		Posts tempPost = new Posts();
		
		if(postRepo.findById(post.getPostID()) != null) {
			if(post.getPostCategory().length() != 0)
				tempPost.setPostCategory(post.getPostCategory());
			if(post.getPostTitle().length() != 0)
				tempPost.setPostTitle(post.getPostTitle());
			if(post.getPostImageURL().length() != 0)
				tempPost.setPostImageURL(post.getPostImageURL());
			if(post.getPost().length() != 0)
				tempPost.setPost(post.getPost());
			if(post.getDay() != 0)
				tempPost.setDay(post.getDay());
			if(post.getMonth() != 0)
				tempPost.setMonth(post.getMonth());
			if(post.getYear() != 0)
				tempPost.setYear(post.getYear());
			tempPost.setFeatured(post.isFeatured());
			tempPost.setSubFeatured(post.isSubFeatured());
			
			post = tempPost;
			
		}
		
		postRepo.save(post);
	}
	
	@RequestMapping(value="/findPost",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Optional<Posts>> findPosts(long postID)
	{
		return new ResponseEntity<>(postRepo.findById(postID), HttpStatus.OK);
	}
	
	@RequestMapping(value="/listPosts",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Posts>> listPosts()
	{
		
		return new ResponseEntity<>(postRepo.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getPost",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Optional<Posts>> getPosts(@RequestBody Posts post) {
		Optional<Posts> postDB = postRepo.findById(post.getPostID());
		
		if(postDB.isPresent() && postDB.get().getPostID() == post.getPostID())
			return new ResponseEntity<>(postDB, HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
}
