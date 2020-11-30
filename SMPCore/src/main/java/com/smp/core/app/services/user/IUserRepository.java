package com.smp.core.app.services.user;

import com.smp.core.app.entity.User;

public interface IUserRepository {

	public User saveUser(User userTemp);
	public User findUserByUserName(String userName);
	public User findUserByEmail(String userEmail);
}
