package com.scb.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.dto.CustomerDto;
import com.scb.entity.Customer;
import com.scb.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);
	
	public Integer createCustomer(CustomerDto custDto) {
		
		Customer customer = null;
	
		if(custDto!=null) {
			try {
				customer = new Customer();
			
				BeanUtils.copyProperties(customer, custDto);
			
				Customer customer2=customerRepository.save(customer);
				logger.debug("customer object from CustomerServiceImpl ", customer2);
				//if(customer2!=null)
					logger.debug("customer object from CustomerServiceImpl ", customer2.getCustId());
				return customer2.getCustId();	
				
			} catch (IllegalAccessException | InvocationTargetException e) {
				
				e.printStackTrace();
			}
		}
				return null;
		
	}
	
	 
	
	
}
