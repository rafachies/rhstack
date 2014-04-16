package org.rchies.rhstack.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rchies.rhstack.model.PaymentDTO;

@Path("/rhstack-service")
public interface PaymentClient extends RestClientInterface {

	@POST
	@Path("/payment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public PaymentDTO pay(PaymentDTO paymentDTO);
	
	
}
