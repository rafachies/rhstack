package org.rchies.rhstack.transfer.service;

import org.rchies.rhstack.transfer.dto.TransferRequest;

public interface RulesComponent {

	public TransferRequest execute(TransferRequest transferRequest);
}
