package com.example.demo.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestHttpPostCallRunner implements CommandLineRunner {
	public void run(String... args) throws Exception {

		//1. Create RestTemplate class object
		RestTemplate rt = new RestTemplate();
		
		//2. Create URL for Producer
		String url = "http://localhost:8080/employee/create";
		
		//__________________________________________________________
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String body = "{\"eid\":101,\"ename\":\"SAM\",\"esal\":250.0}";
		
		HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
		
		//__________________________________________________________
		
		//3. Make Request CALL and get Response
		ResponseEntity<String> response = rt.postForEntity(url, requestEntity, String.class);
		
		
		//4. Print Response details
		log.info("Response Body     : {}",response.getBody());
		log.info("Response code-val : {}",response.getStatusCodeValue());
		log.info("Response code-name: {}",response.getStatusCode().name());
		log.info("Response Headers  : {}",response.getHeaders());
		
		//5. Stop server
		System.exit(0);
	}

}
