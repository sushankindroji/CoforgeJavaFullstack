/**
 * 
 */
package com.coforge.training.hibernatedemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 
 */
@Entity
public class Product {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		private long pid;
	    private String name;
	    private String description;
	    private float price;
	    
		public Product(String name, String description, float price) {
			super();
			this.name = name;
			this.description = description;
			this.price = price;
		}
}
