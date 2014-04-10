package org.rchies.rhstack.payment.component;

import org.rchies.rhstack.payment.dto.PaymentRequest;

public interface DebitComponent {

	public PaymentRequest execute(PaymentRequest paymentRequest);
	
}
