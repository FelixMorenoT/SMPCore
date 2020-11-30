package com.smp.core.app.services.message;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smp.core.app.entity.Alarmas;

public interface IAlarmas extends JpaRepository<Alarmas, Integer> {

}
