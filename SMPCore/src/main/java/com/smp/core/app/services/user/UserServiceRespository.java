package com.smp.core.app.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smp.core.app.dto.UserDTO;
import com.smp.core.app.entity.User;
import com.smp.core.app.utilities.Encrypter;
import com.smp.core.app.utilities.PassGenerator;

@Service
public class UserServiceRespository {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private Encrypter encrypter;
	
	@Autowired
	private PassGenerator passGenerator;
	
	public User userToSave(User tempUser) {
		User tUserByName = userRepository.findUserByUserName(tempUser.getUserName());
		User tUserByMail = userRepository.findUserByEmail(tempUser.getUserMail());
		
		if(tUserByName == null) {
			if (tUserByMail == null) {
				tempUser.setUserPass(encrypter.EncryptPassword(tempUser.getUserPass(), "MD5"));
				userRepository.saveUser(tempUser);
				tUserByName = tempUser;
				
				tempUser.setUserPass("************");
				return tempUser;
			}else {
				tUserByMail.setUserPass("************");
				return tUserByMail;
			}
		}else {
			tUserByName.setUserPass("************");
			return tUserByName;
		}
	}
	
	public String userValidated(String userName, String userPassword) {
		User tUser = userRepository.findUserByUserName(userName);
		
		if (tUser == null) return null;
		
		if(tUser.getUserPass().equals(encrypter.EncryptPassword(userPassword, "MD5"))) {
			return tUser.getUserName();
		}
		
		return null;
	}
	
	public UserDTO resetUser(UserDTO tempUser) {
		User tUser = userRepository.findUserByUserName(tempUser.getUserName());
		
		String tempPass = passGenerator.generateStrongPassword();
		tUser.setUserPass(encrypter.EncryptPassword(tempPass, "MD5"));
		userRepository.saveUser(tUser);
		
		tempUser.setUserPassword(tempPass);
		
		return tempUser;
		
	}
	
	public String updatePassword(UserDTO tempUser) {
		User tUser = userRepository.findUserByUserName(tempUser.getUserName());
		tUser.setUserPass(encrypter.EncryptPassword(tempUser.getUserPassword(), "MD5"));
		
		User result = userRepository.saveUser(tUser);
		
		if(result == null) {
			return null;
		}else {
			return tUser.getUserName();
		}
		
	}
}
