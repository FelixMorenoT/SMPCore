package com.smp.core.app.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smp.core.app.entity.Signos;
import com.smp.core.app.services.signo.ISignos;

@Component
public class LoaderSignos {

	@Autowired
	private ISignos repos;
	
	@Value("${key.code}")
	private String keyCodeAWs;
	
	@Value("${key.hide.code}")
	private String hideKeyCodeAws;
	
	private Regions clientRegion = Regions.US_EAST_2;

	private String bucketName = "signosproperties";
	private String key = "thresholds.json";
	private S3Object fullObject = null;
	
	private static final Logger log = LoggerFactory.getLogger(LoaderSignos.class);

	@PostConstruct
	public void init () throws JsonProcessingException, IOException {
		log.info("Loading Signos Init");
		
		BasicAWSCredentials credentials = new BasicAWSCredentials(keyCodeAWs, hideKeyCodeAws);
		
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion(clientRegion)
                    .build();
        
        fullObject = s3Client.getObject(new GetObjectRequest(bucketName, key));
        
        InputStream is =fullObject.getObjectContent();
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode principalNode = mapper.readTree(is);
		
		Iterator<String> list =  principalNode.fieldNames();
		 while (list.hasNext()) {
			 String keyNode = list.next();
			 JsonNode node = principalNode.get(keyNode);
			 repos.save(new Signos(keyNode, node.get("name").asText(), node.get("max").asText(), node.get("min").asText()));
		 }  
		log.info("Loading Signos End");
	}
}
