package org.rchies.rhstack.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rchies.rhstack.model.TransferDTO;

@Path("/rhstack-service")
public interface TransferClient extends RestClientInterface {

	@POST
	@Path("/transfer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TransferDTO transfer(TransferDTO transferDTO);
	
	
}
