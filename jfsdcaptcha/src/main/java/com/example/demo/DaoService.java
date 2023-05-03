package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DaoService {
	
	@Autowired
	UserRepository repo;

	public void createUser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
		
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
