package com.smp.core.app.rest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smp.core.app.dto.UserDTO;
import com.smp.core.app.entity.User;
import com.smp.core.app.services.user.UserServiceRespository;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/user/v1")
@CrossOrigin("*")
public class UserRestController implements IUserRestController{
	
	@Autowired
	private UserServiceRespository userService;
	
	@Override
	@PostMapping("/user")
	public User saveUser (@RequestBody User user) {
		return userService.userToSave(user);
	}  
	
	@Override
	@PostMapping("/login")
	public ResponseEntity<String> userValidated(@RequestBody UserDTO user) {
		
		return userService.userValidated(user.getUserName(),user.getUserPassword()) == null ? new ResponseEntity<String>("",HttpStatus.BAD_REQUEST): new ResponseEntity<String>(userService.userValidated(user.getUserName(),user.getUserPassword()),HttpStatus.OK);

	}
	
	@Override
	@PatchMapping("/user")
	public UserDTO resetPassword(@RequestBody UserDTO user) {
		return userService.resetUser(user);
	}
	
	@Override
	@PatchMapping("/update")
	public String updatePassword(@RequestBody UserDTO user) {
		return userService.updatePassword(user);
	}
}
