package org.rchies.rhstack.payment.component;

import org.rchies.rhstack.payment.dto.PaymentRequest;

public interface RuleComponent {

	public void execute(PaymentRequest paymentRequest);
}
