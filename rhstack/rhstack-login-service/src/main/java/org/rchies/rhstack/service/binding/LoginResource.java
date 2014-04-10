package org.rchies.rhstack.service.binding;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.rchies.rhstack.service.Credential;

@Path("/authentication")
public interface LoginResource {

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public void login(Credential credential);
	
}
