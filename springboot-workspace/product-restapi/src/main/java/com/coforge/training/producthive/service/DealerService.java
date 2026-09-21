
package com.coforge.training.producthive.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
*Author :shiva
*Date :27-Jul-2026
*Time :3:27:09 pm
*Project :product-restapi
*/



import com.coforge.training.producthive.model.Dealer;
import com.coforge.training.producthive.model.DealerAndAddressProjection;
import com.coforge.training.producthive.repository.DealerRepository;



@Service
public class DealerService {
	@Autowired
	private DealerRepository drepo;
	
	public Dealer registerDealer(Dealer d) {
		return drepo.save(d);
		
	}
	
	public Optional<Dealer> loginDealer(String email) {
		return drepo.findByEmail(email); //Invokes custom method of JPA repo
	}

	public List<DealerAndAddressProjection> getDealerInfo(){
		return drepo.findSelectedFieldsFromDealerAndAddress();
	}
	
	
	
	
}

