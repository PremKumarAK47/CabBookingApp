package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.LoginException;
import com.masai.model.LoginDTO;
import com.masai.service.DriverLoginService;
import com.masai.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService customerLogin;

    @Autowired
    private DriverLoginService driverLogin;

    @PostMapping("/customer")
    public ResponseEntity<String> loginCustomer(@RequestBody LoginDTO dto) throws LoginException {
        String result = customerLogin.logIntoAccount(dto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/customer/logout")
    public ResponseEntity<String> logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
        return new ResponseEntity<>(customerLogin.logOutFromAccount(key), HttpStatus.OK);
    }

    @PostMapping("/driver")
    public ResponseEntity<String> loginDriver(@RequestBody LoginDTO dto) throws LoginException {
        String result = driverLogin.logIntoAccount(dto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/driver/logout")
    public ResponseEntity<String> logoutDriver(@RequestParam(required = false) String key) throws LoginException {
        return new ResponseEntity<>(driverLogin.logOutFromAccount(key), HttpStatus.OK);
    }
}
