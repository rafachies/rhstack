package org.rchies.rhstack.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rchies.rhstack.model.CredentialDTO;

@Path("/rhstack-service")
public interface LoginClient extends RestClientInterface {

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CredentialDTO login(CredentialDTO credential);
	
	@POST
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void logout(CredentialDTO credential);
	
}
