package com.smp.core.app.services.alarma;

import java.util.List;

import com.smp.core.app.entity.Alarma;

public interface IAlarmasRepository {

	public Alarma saveSignos(Alarma signos);
	public List<Alarma> getLists();
}
