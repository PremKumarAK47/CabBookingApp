package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class DriverDetails extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;

	
    
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private CabDetails cab;
	
	
	private String licenseNumber;
	
	
	private Boolean availablity = true;
	
	private int [] currentPosition = new int [2];
	

	
}
