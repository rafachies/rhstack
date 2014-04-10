package org.rchies.rhstack.payment.component;

import org.rchies.rhstack.payment.dto.PaymentRequest;

public interface PaymentService {

	public PaymentRequest pay(PaymentRequest paymentRequest);
}
