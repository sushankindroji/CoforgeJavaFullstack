package com.coforge.training.producthive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*Author :shiva
*Date :28-Jul-2026
*Time :10:27:03 am
*Project :product-restapi
*/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DealerAndAddressProjection {
	
	
	private Long id;
	private String fname;
	private String lname;
	private String phoneNo;
	private String email;
	private String street;
	private  String city;
	private  int pincode;

}
