package org.rchies.rhstack.transfer.service;

import org.rchies.rhstack.transfer.dto.TransferRequest;

public interface DebitComponent {

	public void debit(TransferRequest transferRequest);
}
