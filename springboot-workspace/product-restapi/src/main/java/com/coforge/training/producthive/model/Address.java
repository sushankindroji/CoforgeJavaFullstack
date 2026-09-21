package com.coforge.training.producthive.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *Author :shiva
 *Date :27-Jul-2026
 *Time :3:06:22 pm
 *Project :product-restapi
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Data //ImplementsGetters Setters HashString ,....
@Entity
public class Address {

	@Id  //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Numbering from 1
	private Long addressId;

	private @NonNull String street;
	private @NonNull String city;
	private  int pincode;



	/* Foreign key Relationship*/


	@OneToOne
	@JoinColumn(name="dealer_id")
	private Dealer dealer;



	public Address(@NonNull String street, @NonNull String city, int pincode) {
		super();
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}



	
	



}
