package com.briansjavablog.microservices.bankaccount.client;

import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Retryer;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignConfiguration {

	
	/**
	 * Logging levels are BASIC, FULL, HEADERS, NONE
	 * 
	 * @return
	 */
	@Bean
	public Logger.Level configureLogLevel(){
		return  Logger.Level.BASIC;
	}
	
	/**
	 * Request.Options allows you to configure the connection and 
	 * read timeout values that will be used by the client for each 
	 * request
	 * 
	 * @return Request.Options
	 */
	@Bean 
	public Request.Options timeoutConfiguration(){
		
		return new Request.Options(5000, 30000);
	}
	
	/**
	 * Request interceptor adds HTTP header for basic auth
	 * using the values supplied
	 * 
	 * @return
	 */
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		
		return new BasicAuthRequestInterceptor("user", "password");
	}
	
	/**
	 * An example of a custom RequestInterceptor. In this instance we 
	 * add a custom header. This is a common enough use case for a 
	 * request header 
	 * 
	 * @return RequestInterceptor
	 */
	@Bean
	public RequestInterceptor headerRequestInterceptor() {
		
		return new RequestInterceptor() {
			
			@Override
			public void apply(RequestTemplate template) {
				
				log.info("Adding header [testHeader / testHeaderValue] to request");
				template.header("testHeader", "testHeaderValue");
			}
		};
	}
	
	/** 
	 * Default Retryer will retry 5 times, backing off (exponentially) between retries.
	 * You can provide your own retry logic by implementing the Retry interface if you need 
	 * some specific behaviour. 
	 * 
	 * @return Retryer
	 */
	@Bean
	public Retryer retryer() {
		
		return new Retryer.Default(1000, 8000, 3);		
	}	
	
}
