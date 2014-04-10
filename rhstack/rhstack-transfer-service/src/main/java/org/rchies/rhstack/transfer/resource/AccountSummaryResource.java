package org.rchies.rhstack.transfer.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.rchies.rhstack.transfer.dto.AccountSummaryRequest;

@Path("/")
public interface AccountSummaryResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void askSummary(AccountSummaryRequest accountSummaryRequest);
	
	@GET
	@Path("approve")
	public void approveSummary();
}
