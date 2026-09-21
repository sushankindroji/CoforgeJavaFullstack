package com.coforge.training.springcore.config;

/**
 * Author :sushank2
 * Date :23-Jul-2026
 * Time :12:54:12 pm
 * Project Name :spring-core
 */

public class ProductConfig {

	public static void main(String[] args) {
		// Spring Configuration Class for Annotations



		@Bean
		public Product product1() {
			Product product = new Product();
			product.setName("Laptop");
			product.setPrice(1500.00);
			return product;
		}

		@Bean
		public Product product2() {
			Product product = new Product();
			product.setName("Smartphone");
			product.setPrice(800.00);
			return product;
		}

		@Bean
		public Product product3() {
			Product product = new Product();
			product.setName("Tablet");
			product.setPrice(600.00);
			return product;
		}


	}

}
