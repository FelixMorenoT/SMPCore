package com.smp.core.app.services.alarma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smp.core.app.entity.Alarma;

@Component
public class AlarmasRepository implements IAlarmasRepository{

	@Autowired
	private IAlarmas repository;
	
	@Override
	public Alarma saveSignos(Alarma signos) {
		return repository.save(signos);
	}

	@Override
	public List<Alarma> getLists() {
		return repository.findAll();
	}
}
