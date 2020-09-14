package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.POJO.UsersList;
import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private UserService user_service;
	
	@Autowired	
	public void setUser_service(UserService user_service) {
		this.user_service = user_service;
	}

	@GetMapping()
	public ResponseEntity<UsersList> getAll(HttpServletRequest req) {		
		UsersList ul = this.user_service.getAll();
		return new ResponseEntity<UsersList>(ul, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path="/{id}")
	public User getOne(@PathVariable("id") String id) {
		return this.user_service.find(Integer.valueOf(id));
	}
	
	@PostMapping()
	public User addOne(@RequestBody User user) {
		return this.user_service.addOne(user);
	}
	
	@PatchMapping()
	public User patchOne(@RequestBody User user) {
		return this.user_service.patchOne(user);
	}
	
	@DeleteMapping(path="/{id}")
	public Boolean deleteOne(@PathVariable("id") Integer id) {
		return this.user_service.deleteOne(id);
	}
}
