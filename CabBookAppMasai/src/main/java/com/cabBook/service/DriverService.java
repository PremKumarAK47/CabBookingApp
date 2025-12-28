package com.masai.service;

import com.masai.exceptions.DriverException;
import com.masai.model.DriverDetails;
import com.masai.model.DriverDTO;

public interface DriverService {

	public DriverDetails createDriver(DriverDTO driver)throws DriverException;
}
