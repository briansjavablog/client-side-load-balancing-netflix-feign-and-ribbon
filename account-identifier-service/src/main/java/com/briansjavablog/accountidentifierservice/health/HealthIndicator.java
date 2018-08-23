package com.briansjavablog.accountidentifierservice.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HealthIndicator extends AbstractHealthIndicator {

	@Autowired	
	private Environment environment;
	
	@Override
	protected void doHealthCheck(Builder builder) throws Exception {

		log.info("running health check for {}", environment.getProperty("local.server.port"));
		builder.up();
	}

}
