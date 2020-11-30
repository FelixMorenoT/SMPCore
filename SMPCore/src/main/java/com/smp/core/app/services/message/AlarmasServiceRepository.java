package com.smp.core.app.services.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smp.core.app.entity.Alarmas;

@Service
public class AlarmasServiceRepository {

	@Autowired
	private IAlarmasRepository repo;
	
	
	public Alarmas saveSignos(Alarmas signos) {
		return repo.saveSignos(signos);
	}
}
