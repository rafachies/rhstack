package org.rchies.rhstack.transfer.service;

import org.rchies.rhstack.transfer.dto.AccountSummaryRequest;



public interface AccountSummaryProcess {

	public void askSummary(AccountSummaryRequest accountSummaryRequest);
	
	public void approveSummary();
	
}
