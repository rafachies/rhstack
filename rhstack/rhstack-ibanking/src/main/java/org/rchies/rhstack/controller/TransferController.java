package org.rchies.rhstack.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.rchies.rhstack.client.RestClient;
import org.rchies.rhstack.client.TransferClient;
import org.rchies.rhstack.model.Transfer;
import org.rchies.rhstack.model.TransferDTO;

@Named
public class TransferController {

	@Inject 
	private Transfer transfer;

	@Inject
	private RestClient<TransferClient> restClient;

	@Inject
	private FacesContext facesContext;


	public String transfer() {
		TransferClient transferClient = restClient.getProxy(TransferClient.class);
		TransferDTO dto = new TransferDTO();
		dto.setDebitAccountId(transfer.getDebitAccount());
		dto.setCreditAccountId(transfer.getCreditAccount());
		dto.setUsername(transfer.getUsername());
		dto.setValue(transfer.getValue());
		dto = transferClient.transfer(dto);
		if (dto.getApproved()) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Transfer completed with success", "Success");
			facesContext.addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Transfer not completed: " + dto.getRejectionReason(), "Error");
			facesContext.addMessage(null, message);
		}
		return "home";
	}

}
