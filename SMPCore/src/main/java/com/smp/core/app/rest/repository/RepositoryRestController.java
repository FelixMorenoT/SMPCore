package com.smp.core.app.rest.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smp.core.app.dto.Entry;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/repository/v1")
@CrossOrigin(originPatterns = "*" )
public class RepositoryRestController {

	@GetMapping("/repo/{query}")
	public List<Entry> hello (@PathVariable("query") String query) {
		
		ObjectMapper mapper = new ObjectMapper(); 
		List<Entry> r = null;
		
		try {
			URL theUrl = new URL("http://servidorrepositorios-env.eba-h2ywktga.us-east-2.elasticbeanstalk.com/api/v3/general/" + query);
			HttpURLConnection conn = (HttpURLConnection) theUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			 InputStreamReader in = new InputStreamReader(conn.getInputStream());
			 BufferedReader br = new BufferedReader(in);
			 
			 String output="";
			 StringBuffer buffer = new StringBuffer();
			 while ((output = br.readLine()) != null) {
			 	buffer.append(output);
			 }
			 
			 r =  mapper.readValue(buffer.toString(), new TypeReference<List<Entry>>(){});
			 
			 System.out.println(r.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return r;
	}
}
