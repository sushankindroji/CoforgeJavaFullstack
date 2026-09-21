package com.coforge.training.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Main application class for the API Gateway.
 * 
 * 1. hello-client → hello-service
 *  Old call (direct): -http://localhost:8082/call-hello
 *  New call (through API Gateway): -http://localhost:9090/hello/call-hello
 *  
 *  --------------------------------------------------
 *  
 *  2. employee-client → employee-service
 *  Old calls: http://localhost:8084/call-emp
 *             http://localhost:8084/call-employees
 *             
 *  New calls (through API Gateway):
 *  http://localhost:9090/emp/call-emp
 *  http://localhost:9090/emp/call-employees
 *  
 *  3. registration-service → customer-service
 *  
 *  Old calls: 	http://localhost:8089/client/customers
 *  			http://localhost:8089/client/customers1/2
 *  	 Post - http://localhost:8089/client/customers
 *  
 *  New calls (through API Gateway):
 *  			http://localhost:9090/reg/client/customers
 *      		http://localhost:9090/reg/client/customers/3
 *      Post - 	http://localhost:9090/reg/client/customers
 *     
 *      -----------------------------------------------
 *      4. Actuator Endpoints (through API Gateway) to monitor services
 *         and their health status.
 *      http://localhost:9090/actuator/health
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
