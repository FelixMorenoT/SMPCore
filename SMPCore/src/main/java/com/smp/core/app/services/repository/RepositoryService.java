package com.smp.core.app.services.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smp.core.app.dto.Entry;
import com.smp.core.app.utilities.Connection;

@Service
public class RepositoryService {

	@Value("${server.end.point}")
	private String serverEndpoint;
	
	@Value("${server.service.path.search.repository}")
	private String pathServiceSearchRepo;
	
	public List<Entry> search(String query){
		
		ObjectMapper mapper = new ObjectMapper(); 
		List<Entry> r = null;
		Connection con = null;
		
		try {
			con = new Connection();
			con.stablishConnection
				(serverEndpoint + pathServiceSearchRepo + query, 
						"GET", 
						"application/json");

			
			 InputStreamReader in = new InputStreamReader(con.connectionData());
	
			 StringBuffer buffer = responseData(in);

			 r =  mapper.readValue(buffer.toString(), new TypeReference<List<Entry>>(){});
			 
			 System.out.println(r.toString());
		
		} catch (IOException e) {
			e.printStackTrace();
		}

		return r;
	}
	
	private StringBuffer responseData(InputStreamReader inputData) {
		
	String output="";
	StringBuffer buffer = new StringBuffer();
	BufferedReader br = new BufferedReader(inputData);
	
		try {
			while ((output = br.readLine()) != null) {
			 	buffer.append(output);
			}
			return buffer;
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
	
	}
}
