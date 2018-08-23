package com.briansjavablog.microservices.client;

import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.RetryableException;
import feign.Retryer;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignConfiguration {

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		
		return new BasicAuthRequestInterceptor("user", "password");
	}
	
	@Bean
	public RequestInterceptor requestLoggingInterceptor() {
		
		return new RequestInterceptor() {
			
			@Override
			public void apply(RequestTemplate template) {
				log.info("HTTP Method [{}], URL [{}], Headers [{}]", template.method(), template.url(), template.headers());
			}
		};
	}
	
	@Bean
	public Retryer retryer() {
		
		/* return an instance of our custom retryer impl */
		return new CustomRetryer();			
	}	
	
	/**
	 * Simple implementation of Retryer interface that logs the event
	 * and simply throws the RetryableException. This is here to show how you 
	 * could provide your own retry strategy if you wanted to
	 */
	public class CustomRetryer implements Retryer {
		
		@Override
		public void continueOrPropagate(RetryableException re) {
			
			log.error("Retryable exception ocurred [{}] - will not retry request...", re.getMessage());
			throw re;			
		}
		
		 @Override
	      public Retryer clone() {
	        return this;
	      }
	}
	
}
