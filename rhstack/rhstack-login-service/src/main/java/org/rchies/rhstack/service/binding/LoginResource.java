package org.rchies.rhstack.service.binding;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.rchies.rhstack.service.Credential;

@Path("/")
public interface LoginResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(Credential credential);

}
