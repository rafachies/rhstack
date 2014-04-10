package org.rchies.rhstack.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/test")
public interface TestResource {

	@POST
	@Path("/call")
	@Consumes(MediaType.APPLICATION_JSON)
	public void call(Credential credential);
}
