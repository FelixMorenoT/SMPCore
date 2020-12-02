package com.smp.core.app.services.alarma;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smp.core.app.entity.Alarma;

public interface IAlarmas extends JpaRepository<Alarma, Integer> {

}
