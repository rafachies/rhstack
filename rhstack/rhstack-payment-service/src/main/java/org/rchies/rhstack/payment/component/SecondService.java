package org.rchies.rhstack.payment.component;

import org.rchies.rhstack.payment.dto.PaymentRequest;

public interface SecondService {

	public PaymentRequest send(PaymentRequest paymentRequest);
}
