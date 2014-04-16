package org.rchies.rhstack.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.rchies.rhstack.client.PaymentClient;
import org.rchies.rhstack.client.RestClient;
import org.rchies.rhstack.model.Payment;
import org.rchies.rhstack.model.PaymentDTO;

@Named
public class PaymentController {

	@Inject 
	private Payment payment;

	@Inject
	private RestClient<PaymentClient> restClient;

	@Inject
	private FacesContext facesContext;


	public String pay() {
		PaymentClient paymentClient = restClient.getProxy(PaymentClient.class);
		PaymentDTO dto = new PaymentDTO();
		dto.setAccountId(payment.getAccount());
		dto.setUsername(payment.getUsername());
		dto.setPaymentValue(payment.getValue());
		dto.setPaymentCode(payment.getCode());
		dto = paymentClient.pay(dto);
		if (dto.getApproved()) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Payment completed with success", "Success");
			facesContext.addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Payment not completed: " + dto.getRejectionReason(), "Error");
			facesContext.addMessage(null, message);
		}
		return "home";
	}

}
