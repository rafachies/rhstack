package org.rchies.rhstack.service;

import org.apache.camel.builder.RouteBuilder;

public class LogoutServiceRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		from("switchyard://LogoutService")
		.log("Received message for 'LogoutService' : ${body}")
		.to("switchyard://CacheService?operationName=logout");
	}

}
