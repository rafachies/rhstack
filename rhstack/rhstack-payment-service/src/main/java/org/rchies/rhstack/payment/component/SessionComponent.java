package org.rchies.rhstack.payment.component;

import org.rchies.rhstack.payment.dto.PaymentRequest;


public interface SessionComponent {

	public PaymentRequest check(PaymentRequest paymentRequest);
}
