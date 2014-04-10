package org.rchies.rhstack.payment.component;

import javax.inject.Inject;

import org.rchies.rhstack.payment.dto.PaymentRequest;
import org.slf4j.Logger;
import org.switchyard.component.bean.Service;

@Service(DebitComponent.class)
public class DebitComponentBean implements DebitComponent {

	@Inject
	private Logger logger;
	
	@Override
	public PaymentRequest execute(PaymentRequest paymentRequest) {
		logger.info("Debiting {} from account {}", paymentRequest.getPaymentValue(), paymentRequest.getAccountId());
		return paymentRequest;
	}

}
