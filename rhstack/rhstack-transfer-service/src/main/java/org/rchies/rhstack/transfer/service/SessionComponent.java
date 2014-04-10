package org.rchies.rhstack.transfer.service;

import org.rchies.rhstack.transfer.dto.TransferRequest;

public interface SessionComponent {

	public TransferRequest checkCredential(TransferRequest transferRequest);
	
}
