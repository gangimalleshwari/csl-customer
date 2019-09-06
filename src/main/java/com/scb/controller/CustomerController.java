package com.scb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.scb.dto.CustomerDto;
import com.scb.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final Logger logger = LogManager.getLogger(CustomerController.class);
	private  String uri;
	@PostMapping("/create")
	public ResponseEntity<String> createCustomer(@RequestBody CustomerDto cuDto){
		 
		Integer custId= customerService.createCustomer(cuDto);
		if(custId!=null) {
			uri = "http://localhost:2020/cashflow/account/create/"+custId;
		}
		logger.debug("custId from DB", custId);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<Integer> acctId = restTemplate.postForEntity(uri, custId, Integer.class);
		 if(acctId!=null)
		 return new ResponseEntity<String>("Customer Details Saved Successfully.",HttpStatus.CREATED);
		 return null;
		 
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
