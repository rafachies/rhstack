package org.rchies.rhstack.payment.component;

import org.apache.camel.builder.RouteBuilder;

public class PaymentServiceRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		from("switchyard://PaymentService")
		.log("Payment received: ${body}")
		.to("switchyard://SessionComponent")
		.filter(simple("${body.approved} == true"))
		.log("Body before rules: ${body}")
		.to("switchyard://RuleComponent")
		.log("Body after rules: ${body}")
		.choice()
			.when(simple("${body.approved} == true"))
				.to("switchyard://DebitComponent")
				.to("switchyard://VendorService")
			.otherwise()
				.log("Payment not approved")
		.endChoice()
		.log("Payment response: ${body}")
		.end();
	}
}
