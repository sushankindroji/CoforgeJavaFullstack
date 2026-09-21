package com.coforge.training.producthive.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coforge.training.producthive.model.Dealer;
import com.coforge.training.producthive.model.DealerAndAddressProjection;

/**
*Author :shiva
*Date :27-Jul-2026
*Time :3:23:43 pm
*Project :product-restapi
*/

public interface DealerRepository extends JpaRepository<Dealer,Long> {

	public Optional<Dealer> findByEmail(String email);
	
	public List<Dealer> findByLname(String lname);
	
	@Query("SELECT new com.coforge.training.producthive.model.DealerAndAddressProjection"
			+ "(d.id,d.fname,d.lname,d.phoneNo,"
			+ "d.email,a.street,a.city,a.pincode)"
			+ " FROM Dealer d JOIN d.address a")
	List<DealerAndAddressProjection> findSelectedFieldsFromDealerAndAddress(); 
	
	

	
	

}
