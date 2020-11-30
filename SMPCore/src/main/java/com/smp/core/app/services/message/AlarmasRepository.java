package com.smp.core.app.services.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smp.core.app.entity.Alarmas;

@Component
public class AlarmasRepository implements IAlarmasRepository{

	@Autowired
	private IAlarmas repository;
	
	@Override
	public Alarmas saveSignos(Alarmas signos) {
		return repository.save(signos);
	}
}
