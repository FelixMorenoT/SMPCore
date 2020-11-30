package com.smp.core.app.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class Encrypter {

	private MessageDigest messageDigest;
	
	public String EncryptPassword(String password, String typeEncrypt) {
		try {
			messageDigest = MessageDigest.getInstance(typeEncrypt);
			messageDigest.update(password.getBytes());
			
			byte[] bytes = messageDigest.digest();
			
		    StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            password = sb.toString();
			
			return password;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
