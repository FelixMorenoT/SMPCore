package com.smp.core.app.rest.repository;

import java.util.List;

import com.smp.core.app.dto.Entry;

public interface IRepositoryRestController {

	public List<Entry> searchQuery(String query);
}
