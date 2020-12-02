package com.smp.core.app.services.signo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smp.core.app.entity.Signos;

public interface ISignos extends JpaRepository<Signos, Integer> {

	@Query("SELECT s.signoName FROM Signos s WHERE s.singoId = ?1")
	public String findBySignoCode(String code); 
}
