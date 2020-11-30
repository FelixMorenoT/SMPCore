package com.smp.core.app.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smp.core.app.entity.User;

@Component
public class UserRepository implements IUserRepository {

	@Autowired
	private IRepository userRepo;
	
	@Override
	public User saveUser(User userTemp) {
		return userRepo.save(userTemp);
	}

	@Override
	public User findUserByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}
	
	@Override
	public User findUserByEmail(String userEmail) {
		return userRepo.findByEmail(userEmail);
	}
	
}
