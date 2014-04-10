package org.rchies.rhstack.service;

import org.apache.camel.builder.RouteBuilder;

public class LoginServiceRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		from("switchyard://LoginService")
		.log("Received message for 'LoginService' : ${body}")
		.to("switchyard://AuthenticatorService")
		.choice()
			.when(simple("${body.authenticated} == true"))
				.to("switchyard://CacheService?operationName=login")
			.otherwise()
				.log("Camel route: Unauthenticated")
		.end();
	}

}
