package org.rchies.rhstack.transfer.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.rchies.rhstack.transfer.dto.TransferRequest;

@Path("/")
public interface TransferResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public TransferRequest transfer(TransferRequest transferRequest);
}
