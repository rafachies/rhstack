package org.rchies.rhstack.transfer.service;

import org.rchies.rhstack.transfer.dto.TransferRequest;

public interface CreditComponent {

	public void credit(TransferRequest transferRequest);
}
