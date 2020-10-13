package com.sbm.dealer.config;

import com.sbm.dealer.common.exception.GenericExceptionMapper;
import com.sbm.dealer.controller.DealerController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class RestConfig extends ResourceConfig {

	public RestConfig() {

		register(DealerController.class);
		register(GenericExceptionMapper.class);
	}
}