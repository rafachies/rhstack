package org.rchies.rhstack.payment.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.rchies.rhstack.payment.dto.PaymentRequest;

@Path("/")
public interface PaymentResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public PaymentRequest pay(PaymentRequest paymentRequest);
}
