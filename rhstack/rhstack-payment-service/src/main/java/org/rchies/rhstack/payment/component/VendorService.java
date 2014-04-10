package org.rchies.rhstack.payment.component;

import org.rchies.rhstack.payment.dto.PaymentRequest;

public interface VendorService {

	public void pay(PaymentRequest paymentRequest);
	
}
