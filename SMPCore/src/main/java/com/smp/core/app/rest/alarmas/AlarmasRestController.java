package com.smp.core.app.rest.alarmas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smp.core.app.entity.Alarma;
import com.smp.core.app.services.alarma.AlarmasServiceRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/alarmas/v1")
public class AlarmasRestController implements IAlarmasRestController {

	@Autowired
	private AlarmasServiceRepository serviceAlarma;
	
	@Override
	@GetMapping("/list")
	public List<Alarma> listAlarmas() {
		return serviceAlarma.getLists();
	}

}
