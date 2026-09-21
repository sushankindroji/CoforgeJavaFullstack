package com.coforge.training.producthive.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.coforge.training.producthive.exception.ResourceNotFoundException;
import com.coforge.training.producthive.model.Product;
import com.coforge.training.producthive.service.ProductService;

/**
 *Author :shiva
 *Date :27-Jul-2026
 *Time :11:59:52 am
 *Project :product-restapi
 */


/*
 * In Spring Boot, a Response Entity is a class that helps in returning a response to a HTTP request. 
 * It's part of the Spring Framework and is used to simplify the process of returning HTTP responses. 
 * 
 * A ResponseEntity typically includes the HTTP status code, headers, and a body. 
 * This can be a JSON or XML response, or even a simple string. 
 * ResponseEntity is a powerful and flexible way to return responses from a Spring Boot application, 
 * making it easy to manage HTTP communication and handle errors.
 * 
 * @RequestBody annotation automatically deserializes the JSON into a Java type
 * 
 * @Validated annotation is a tool that helps validate the data being passed to a controller method. 
 */

//Open PostMan, make a POST Request - http://localhost:8088/producthive/api/products
//Select body -> raw -> JSON 
//Insert JSON product object.

/**Spring RestController annotation is used to create RESTful web services using Spring MVC. 
 * Spring RestController takes care of mapping request data to the defined request handler method. 
 * Once response body is generated from the handler method, it converts it to JSON or XML response.
 *  
 * @RestController indicates that this class handles HTTP requests and automatically 
 * serializes the results to JSON.
 * 
 * @RequestMapping - maps HTTP request with a path to a controller**/



@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})
@RestController
@RequestMapping(value="/api")

public class ProductController {


	@Autowired
	private ProductService pservice;


	@PostMapping("/products")
	public ResponseEntity<Product> saveProduct(@Validated @RequestBody Product product) {
		try {
			Product p=pservice.saveProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(p);
		}catch(Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);


		}
	}

	//Open PostMan/Browser, make a GET Request - http://localhost:8088/producthive/api/products
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		try {
			List<Product> products=pservice.listAll();//Invoke listAll() service method
			return ResponseEntity.ok(products);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/products/{pid}")
	public ResponseEntity<Product> getProductById(@PathVariable(value="pid") Long pId)
			throws ResourceNotFoundException{

		Product p=pservice.getSingleProduct(pId).orElseThrow(()->
		new ResourceNotFoundException("Product Not FOund for the id:"+pId));


		return ResponseEntity.ok(p);
	}
	
	
	@PutMapping("/products/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value="pid") Long pId,
			@Validated @RequestBody Product p)throws ResourceNotFoundException{
		
		Product product=pservice.getSingleProduct(pId).
				orElseThrow(() -> new ResourceNotFoundException("Product Not Found for this Id :"+pId));
		//Update product with new values
		product.setBrand(p.getBrand());
		product.setMadein(p.getMadein());
		product.setName(p.getName());
		product.setPrice(p.getPrice());

		final Product updatedProduct=pservice.saveProduct(product); // invokes service layer method
		return ResponseEntity.ok().body(updatedProduct);
	}
	
	
	
	
	@PatchMapping("/products/{pid}")
	public ResponseEntity<Product> updateProductPriceAndMadein(
	        @PathVariable(value = "pid") Long pId,
	        @Validated @RequestBody Product p) throws ResourceNotFoundException {

	    // Fetch existing product from DB
	    Product product = pservice.getSingleProduct(pId)
	            .orElseThrow(() -> new ResourceNotFoundException("Product Not Found for this Id: " + pId));

	    // Update only price and madein if provided in request
	    if (p.getPrice() != 0.0f) {
	        product.setPrice(p.getPrice());
	    }
	    if (p.getMadein() != null) {
	        product.setMadein(p.getMadein());
	    }

	    // Save updated product
	    final Product updatedProduct = pservice.saveProduct(product);
	    return ResponseEntity.ok().body(updatedProduct);
	}
	

	//Open PostMan, make a DELETE Request - http://localhost:8088/product-hive/api/products/1004


@DeleteMapping("/products/{pid}")
public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable(value="pid") Long pId)
throws ResourceNotFoundException{

    pservice.getSingleProduct(pId).  // invokes service layer method
		orElseThrow(() -> new ResourceNotFoundException("Product Not Found for this Id :"+pId));

		pservice.deleteProduct(pId); // invokes service layer method

		Map<String,Boolean> response=new HashMap<>(); //Map Stores Data in key-value pairs
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	
}

@GetMapping("/search")
public ResponseEntity<?> searchProductsByName(@RequestParam("name") String name) {
    try {
        List<Product> products = pservice.searchProductsByName(name);
        
        if (products.isEmpty()) {
            return new ResponseEntity<>("No products found with the given name.", HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(products, HttpStatus.OK);
    } catch (Exception ex) {
    	//database error
        return new ResponseEntity<>("An error occurred while searching for products.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
	


}
