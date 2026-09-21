package com.coforge.training.producthive.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coforge.training.producthive.model.Product;
import com.coforge.training.producthive.repository.ProductRepository;

/**
*Author :shiva
*Date :27-Jul-2026
*Time :11:53:24 am
*Project :product-restapi
*/



/**@Service annotation is a stereotype annotation that marks a class as a service layer component. 
 * It's one of the core annotations used to structure your application and enable dependency injection.
 * 
 * The @Service annotation tells Spring that the annotated class contains business logic. 
 * It's typically where you'll implement the core functionality of your application, 
 * such as calculations, data retrieval, or external API interactions.**/

@Service
public class ProductService {
	
	
	private final ProductRepository prepo;

	
	
	//Constructor Dependency Injection - Generate Constructor using Field
	public ProductService(ProductRepository prepo) {
		super();
		this.prepo = prepo;
	}
	
	public Product saveProduct(Product p) {
		return prepo.save(p);
	}
	public List<Product> listAll(){
		return prepo.findAll();  //Invokes pre-defined method findAll() of JPA repository
	}
	
	
	
	// Optional return type is to handle Null Pointer Exception
	   public Optional<Product> getSingleProduct(long pid) {
		   return prepo.findById(pid);            //Invokes pre-defined method findById() of JPA repository
	   }
	
	   
	   public void deleteProduct(long pid) {
		   prepo.deleteById(pid); //Invokes pre-defined method deleteById() of JPA repository
	   }
	   
	   
	   
	   
	   public List<Product> searchProductsByName(String name){
		   return prepo.findProductsByNameContainingIgnoreCase(name);
	   }
	   
	   
	   
	   
	   
	   
}
