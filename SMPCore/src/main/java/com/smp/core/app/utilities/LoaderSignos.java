package com.smp.core.app.utilities;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smp.core.app.entity.Signos;
import com.smp.core.app.services.message.ISignos;

@Component
public class LoaderSignos {

	@Autowired
	private ISignos repos;
	
	private static final Logger log = LoggerFactory.getLogger(LoaderSignos.class);

	@PostConstruct
	public void init () throws JsonProcessingException, IOException {
		log.info("Loading Signos Init");
		File f = new File("D:\\Repositorios\\SMPCore-Repo\\SMPCore\\thresholds.json");
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode principalNode = mapper.readTree(f);
		
		Iterator<String> list =  principalNode.fieldNames();
		 while (list.hasNext()) {
			 String keyNode = list.next();
			 JsonNode node = principalNode.get(keyNode);
			 repos.save(new Signos(keyNode, node.get("name").asText(), node.get("max").asText(), node.get("min").asText()));
		 }  
		log.info("Loading Signos End");
	}
}
