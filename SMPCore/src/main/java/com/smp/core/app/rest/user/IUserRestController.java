package com.smp.core.app.rest.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.smp.core.app.dto.UserDTO;
import com.smp.core.app.entity.User;

public interface IUserRestController {

	public User saveUser (@RequestBody User user);
	public ResponseEntity<String> userValidated(@RequestBody UserDTO user);
	public UserDTO resetPassword(@RequestBody UserDTO user);
	public String updatePassword(@RequestBody UserDTO user);
}
