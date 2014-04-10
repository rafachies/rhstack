package org.rchies.rhstack.transfer.service;

import org.rchies.rhstack.transfer.dto.TransferRequest;

public interface EnrichComponent {

	public TransferRequest enrich(TransferRequest transferRequest);
	
}
