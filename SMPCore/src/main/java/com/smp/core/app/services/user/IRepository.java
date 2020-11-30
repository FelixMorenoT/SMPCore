package com.smp.core.app.services.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smp.core.app.entity.User;

public interface IRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.userName = ?1")
	User findByUserName(String userName);
	
	@Query("SELECT u FROM User u WHERE u.userMail = ?1")
	User findByEmail(String userEmail);
}
