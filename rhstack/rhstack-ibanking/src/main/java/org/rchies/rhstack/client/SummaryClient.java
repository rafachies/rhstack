package org.rchies.rhstack.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.rchies.rhstack.model.AccountSummary;

@Path("/rhstack-service/summary")
public interface SummaryClient extends RestClientInterface {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void askSummary(AccountSummary accountSummary, @HeaderParam("correlationKey") String correlationKey);
	
	@GET
	@Path("/approve")
	public void approveSummary(@HeaderParam("correlationKey") String correlationKey);
	
}
