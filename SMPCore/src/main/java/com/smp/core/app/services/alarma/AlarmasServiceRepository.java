package com.smp.core.app.services.alarma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smp.core.app.entity.Alarma;

@Service
public class AlarmasServiceRepository {

	@Autowired
	private IAlarmasRepository repo;
	
	
	public Alarma saveSignos(Alarma signos) {
		return repo.saveSignos(signos);
	}
	
	public List<Alarma> getLists(){
		return repo.getLists();
	}
}
