package org.rchies.rhstack.transfer.service;

import org.apache.camel.builder.RouteBuilder;

public class TransferServiceRoute extends RouteBuilder {

	public void configure() {
		from("switchyard://TransferService")
			.log("Transfer request receive: ${body}")
			.to("switchyard://SessionComponent")
			.filter(simple("${body.approved} == true"))
			.to("switchyard://EnrichComponent")
			.log("Now lets call the rules component")
			.to("switchyard://RulesComponent")
			.filter(simple("${body.approved} == true"))
			.to("switchyard://DebitComponent")
			.to("switchyard://CreditComponent")
			.end();
	}

}
