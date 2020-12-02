package com.smp.core.app.rest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smp.core.app.dto.Entry;
import com.smp.core.app.services.repository.RepositoryService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/repository/v1")
@CrossOrigin(originPatterns = "*" )
public class RepositoryRestController implements IRepositoryRestController {

	@Autowired
	private RepositoryService repositoryService;
	
	@Override
	@GetMapping("/repo/{query}")
	public List<Entry> searchQuery (@PathVariable("query") String query) {
		List<Entry> tempList = repositoryService.search(query);
		return tempList;
	}
}
