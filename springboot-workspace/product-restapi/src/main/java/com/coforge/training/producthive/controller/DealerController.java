package com.coforge.training.producthive.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.producthive.exception.ResourceNotFoundException;
import com.coforge.training.producthive.model.Address;
import com.coforge.training.producthive.model.Dealer;
import com.coforge.training.producthive.model.DealerAndAddressProjection;
import com.coforge.training.producthive.service.DealerService;

/**
*Author :shiva
*Date :27-Jul-2026
*Time :3:30:00 pm
*Project :product-restapi
*/

/*
 * Cross-Origin Resource Sharing (CORS) is a security feature implemented by web browsers
 * to restrict web pages from making requests to a different domain than the one
 * that served the web page.
 */


@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})
@RestController
@RequestMapping(value="/api")
public class DealerController {
	
	
	private final DealerService dservice;

	public DealerController(DealerService dservice) {
		super();
		this.dservice = dservice;
	}
	
	
		
		
	@PostMapping("/register")
	public ResponseEntity<String> createDealer(@Validated @RequestBody Dealer dealer){
		try {
			Address address=dealer.getAddress(); //get data from secondary Table

			//Establish bi-directional Mapping
			address.setDealer(dealer);
			dealer.setAddress(address);

			Dealer registeredDealer=dservice.registerDealer(dealer); //save dealer details
			if(registeredDealer !=null) {
				return ResponseEntity.ok("Registration Successfull");
			}else {
				return ResponseEntity.badRequest().body("Registration Failed");
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
					body("An Error Occurred :"+e.getMessage());
		}
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> loginDealer(@Validated @RequestBody Dealer dealer) 
			throws ResourceNotFoundException
	{
		Boolean isLogin=false;
		
		String email = dealer.getEmail();
		String password =  dealer.getPassword();
		
		Dealer d= dservice.loginDealer(email).orElseThrow(() -> //Invokes loginDealer() method with email parameter
		new ResourceNotFoundException("Dealer doen't Exists :: " +email));
		
		if(email.equals(d.getEmail()) && password.equals(d.getPassword())) {
			isLogin=true;
		}
		return ResponseEntity.ok(isLogin);
	}

	
	@GetMapping("/dealers")
	public ResponseEntity<List<DealerAndAddressProjection>> getDealerInfo(){
		try {
			List<DealerAndAddressProjection> selectedFields=dservice.getDealerInfo();
			
			return ResponseEntity.ok(selectedFields);
		}catch(Exception e) {
			e.printStackTrace();
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	
	
	
}
