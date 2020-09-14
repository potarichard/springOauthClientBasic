package com.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.POJO.UsersList;
import com.entity.User;
import com.repository.UserDao;

@Service
public class UserService {

	private UserDao user_dao;

	@Autowired
	public void setUser_dao(UserDao user_dao) {
		this.user_dao = user_dao;
	}
	
	public UsersList getAll() {
		UsersList ul = new UsersList();
		ul.entities =  this.user_dao.findAll();
		return ul;
	}

	public User find(Integer id) {
		return this.user_dao.findById(id).get();
	}

	public User addOne(User user) {		
		return this.user_dao.save(user);
	}

	public User patchOne(User user) {
		return this.user_dao.save(user);
	}

	public Boolean deleteOne(Integer id) {
		
		try {
			User u = this.user_dao.findById(id).get();
			this.user_dao.delete(u);
		}
		catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
//	@PostConstruct
//	public void init() {
//		List.of(new User("Jojo"), new User("Dio")).forEach(user -> this.user_dao.save(user));
//	}
}