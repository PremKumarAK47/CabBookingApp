package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.DriverException;
import com.masai.model.DriverDetails;
import com.masai.model.DriverDTO;
import com.masai.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
    
	@Autowired
	private DriverService dservice ;
	
	@PostMapping("/register")
	public ResponseEntity<DriverDetails> createDriver(@Valid @RequestBody DriverDTO driver) throws DriverException{
		
	    DriverDetails  d= dservice.createDriver(driver);
	    
	    return new ResponseEntity<DriverDetails>(d,HttpStatus.CREATED);
		
	}
	
	
	
}
