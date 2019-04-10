package com.briansjavablog.microservices.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RibbonClient(name="account-identifier-service")
public class RibbonConfiguration {

	
	@Bean
	public IRule loadBlancingRule() {
		
		new WeightedResponseTimeRule();
		new AvailabilityFilteringRule();
		new WeightedResponseTimeRule();		
		return new RoundRobinRule();
	}

	
	@Bean
	public IPing pingConfiguration(ServerList<Server> servers) {
		
		String pingPath = "/actuator/health";
		IPing ping = new PingUrl(false, pingPath);				
		log.info("Configuring ping URI to [{}]", pingPath);
		
		return ping;		
	}
	
	
	@Bean
	public ServerList<Server> serverList() {
		
		return new ServerList<Server>() {
			
			@Override
			public List<Server> getUpdatedListOfServers() {

				List<Server> serverList = Arrays.asList(new Server("http", "localhost", 8091), new Server("http", "localhost", 8092));				
				log.info("Returning updated list of servers [{}]", serverList);
				return serverList;
			}
			
			@Override
			public List<Server> getInitialListOfServers() {

				return Arrays.asList(new Server("http", "localhost", 8091), new Server("http", "localhost", 8092));
			}
		};
	}
	
}
